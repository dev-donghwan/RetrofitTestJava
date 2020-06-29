package com.example.retrofittestjava.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DA {

    @SerializedName("boxOfficeResult")
    @Expose
    private DTO DTO;

    public DTO getDTO() {
        return DTO;
    }

    public void setDTO(DTO DTO) {
        this.DTO = DTO;
    }
}
