package org.csu.hospital.persistence;

import org.csu.hospital.domain.Ward;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WardMapper {
    void updateWard(Ward ward);
    void deleteWard(int id);
    List<Ward> getWards();
    List<Ward> getWardsByWardId(int wordId);
}
