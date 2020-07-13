package org.csu.hospital.persistence;

import org.springframework.stereotype.Repository;

@Repository
public interface MedicineMapper {
    double getPriceByMedicineId(int id);
}
