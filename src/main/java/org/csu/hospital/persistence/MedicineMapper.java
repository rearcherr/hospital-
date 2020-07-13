package org.csu.hospital.persistence;

import org.csu.hospital.domain.Medicine;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineMapper {
    double getPriceByMedicineId(int id);
    Medicine getMedicineById(int id);
}
