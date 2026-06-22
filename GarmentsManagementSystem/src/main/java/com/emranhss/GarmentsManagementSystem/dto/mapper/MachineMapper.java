package com.emranhss.GarmentsManagementSystem.dto.mapper;

import com.emranhss.GarmentsManagementSystem.dto.request.MachineRequestDto;
import com.emranhss.GarmentsManagementSystem.dto.response.MachineResponseDto;
import com.emranhss.GarmentsManagementSystem.entity.Machine;

public class MachineMapper {

    public static Machine toEntity(
            MachineRequestDto dto) {

        if (dto == null) {
            return null;
        }

        Machine machine = new Machine();

        machine.setMachineId(dto.getMachineId());
        machine.setMachineName(dto.getMachineName());
        machine.setType(dto.getType());
        machine.setActive(true);

        return machine;
    }

    public static MachineResponseDto toDto(
            Machine machine) {

        if (machine == null) {
            return null;
        }

        MachineResponseDto dto =
                new MachineResponseDto();

        dto.setId(machine.getId());
        dto.setMachineId(machine.getMachineId());
        dto.setMachineName(machine.getMachineName());
        dto.setType(machine.getType());
        dto.setActive(machine.getActive());

        if (machine.getProductionLine() != null) {
            dto.setProductionLineId(machine.getProductionLine().getId());

            // আপনার ProductionLine এনটিটিতে যে ফিল্ড আছে (যেমন: getLineId() বা getLineCode()) সেটি এখানে বসবে
            dto.setProductionLineCode(machine.getProductionLine().getLineId());
        }

        return dto;
    }
}
