package org.csu.hospital.persistence;

import org.csu.hospital.domain.Patient;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMapper {
    int selectAccountFromUsername(long username);
    int selectAccountFromUsernameAndPwd(Patient patient);
}
