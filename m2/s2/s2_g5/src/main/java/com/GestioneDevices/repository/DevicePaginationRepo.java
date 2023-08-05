package com.GestioneDevices.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.GestioneDevices.entity.Device;

public interface DevicePaginationRepo extends PagingAndSortingRepository<Device, Long> {

}
