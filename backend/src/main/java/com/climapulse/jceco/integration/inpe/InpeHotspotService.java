package com.climapulse.jceco.integration.inpe;

import org.springframework.stereotype.Service;

@Service
public class InpeHotspotService {

    private final InpeHotspotImporter importer;
    private final InpeHotspotCsvClient csvClient;

    public InpeHotspotService(
            InpeHotspotImporter importer,
            InpeHotspotCsvClient csvClient
    ) {
        this.importer = importer;
        this.csvClient = csvClient;
    }

    public void importRecentHotspots() {
        var csvFiles = csvClient.fetchRecentCsvs();

        for (var csvFile : csvFiles) {
            importer.importFile(csvFile);
        }
    }
}
