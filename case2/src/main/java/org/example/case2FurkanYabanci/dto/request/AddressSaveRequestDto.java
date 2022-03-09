package org.example.case2FurkanYabanci.dto.request;

import lombok.Data;
import org.example.case2FurkanYabanci.dto.*;

@Data
public class AddressSaveRequestDto {

    private int doorNumber;
    private int apartmentNumber;
    private long countryId;
    private long cityId;
    private long districtId;
    private long neighborhoodId;
    private long streetId;
}
