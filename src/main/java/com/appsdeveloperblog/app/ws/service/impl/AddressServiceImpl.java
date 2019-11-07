package com.appsdeveloperblog.app.ws.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.appsdeveloperblog.app.ws.io.entity.AddressEntity;
import com.appsdeveloperblog.app.ws.io.entity.UserEntity;
import com.appsdeveloperblog.app.ws.io.repositories.AddressRepository;
import com.appsdeveloperblog.app.ws.io.repositories.UserRepository;
import com.appsdeveloperblog.app.ws.service.AddressService;
import com.appsdeveloperblog.app.ws.shared.dto.AddressDTO;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public AddressDTO getAddressById(String addressId) {
		AddressEntity addressEntity = addressRepository.findByAddressId(addressId);

		if (addressEntity == null) {
			throw new UsernameNotFoundException(addressId);
		}

		ModelMapper modelMapper = new ModelMapper();
		AddressDTO returnValue = modelMapper.map(addressEntity, AddressDTO.class);

		return returnValue;

	}

	@Override
	public List<AddressDTO> getAddresses(String userId) {
		List<AddressDTO> returnValue = new ArrayList<>();

		UserEntity userEntity = userRepository.findByUserId(userId);

		List<AddressEntity> addresses = addressRepository.findByUserDetails(userEntity);

		ModelMapper modelMapper = new ModelMapper();

		if (addresses != null) {
			for (AddressEntity addressEntity : addresses) {
				AddressDTO addressDto = modelMapper.map(addressEntity, AddressDTO.class);
				returnValue.add(addressDto);
			}
		}

		return returnValue;

	}
}
