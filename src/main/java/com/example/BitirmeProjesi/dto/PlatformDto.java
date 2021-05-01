package com.example.BitirmeProjesi.dto;

import com.example.BitirmeProjesi.Entity.Broadcast;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatformDto {

    private String platform_name;

    private BroadcastDto broadcast;
}
