package org.csu.hospital.persistence;

import org.csu.hospital.domain.Ward;
import org.springframework.stereotype.Repository;

@Repository
public interface WardMapper {
    void updateWard(Ward ward);
    void deleteWard(int id);
}
