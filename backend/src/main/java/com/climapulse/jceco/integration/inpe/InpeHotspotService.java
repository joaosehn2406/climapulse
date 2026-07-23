package com.climapulse.jceco.integration.inpe;

import org.springframework.stereotype.Service;

import java.io.StringReader;
import java.util.List;

@Service
public class InpeHotspotService {

    private final InpeHotspotCsvParser inpeHotspotCsvParser;
    private final InpeHotspotCsvClient inpeHotspotCsvClient;

    public InpeHotspotService(InpeHotspotCsvParser inpeHotspotCsvParser, InpeHotspotCsvClient inpeHotspotCsvClient) {
        this.inpeHotspotCsvParser = inpeHotspotCsvParser;
        this.inpeHotspotCsvClient = inpeHotspotCsvClient;
    }

    public List<InpeHotspot> importRecentHotspots() {
        var csvFiles = inpeHotspotCsvClient.fetchRecentCsvs();

        return csvFiles.stream()
                .flatMap(csvFile -> inpeHotspotCsvParser.parse(new StringReader(csvFile.content())).stream())
                .toList();
    }
}
