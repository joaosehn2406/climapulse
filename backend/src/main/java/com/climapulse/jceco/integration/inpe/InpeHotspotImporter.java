package com.climapulse.jceco.integration.inpe;

import jakarta.transaction.Transactional;

import java.io.StringReader;
import java.time.Instant;

public class InpeHotspotImporter {

    private final InpeHotspotCsvParser parser;
    private final InpeImportRepository inpeImportRepository;
    private final HotspotRepository hotspotRepository;

    public InpeHotspotImporter(
            InpeHotspotCsvParser parser,
            InpeImportRepository inpeImportRepository,
            HotspotRepository hotspotRepository
    ) {
        this.parser = parser;
        this.inpeImportRepository = inpeImportRepository;
        this.hotspotRepository = hotspotRepository;
    }

    @Transactional
    public boolean importFile(InpeCsvFile file) {
        if (inpeImportRepository.existsById(file.filename())) {
            return false;
        }

        var hotspots = parser.parse(
                new StringReader(file.content())
        );

        inpeImportRepository.saveAndFlush(
                new InpeImportEntity(file.filename(), Instant.now())
        );

        var hotspotEntities = hotspots.stream()
                .map(hotspot -> new HotspotEntity(
                        file.filename(),
                        hotspot
                ))
                .toList();

        hotspotRepository.saveAll(hotspotEntities);

        return true;
    }
}
