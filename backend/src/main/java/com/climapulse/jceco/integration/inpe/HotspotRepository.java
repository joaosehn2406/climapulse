package com.climapulse.jceco.integration.inpe;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HotspotRepository extends JpaRepository<HotspotEntity, UUID> { }
