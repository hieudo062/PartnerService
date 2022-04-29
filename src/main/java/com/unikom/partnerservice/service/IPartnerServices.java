package com.unikom.partnerservice.service;

import com.unikom.partnerservice.dto.PartnerDTO;
import com.unikom.partnerservice.dto.request.Search;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPartnerServices {
    PartnerDTO save(PartnerDTO partnerDTO);
    PartnerDTO delete(Long id);
    List<PartnerDTO> search(Search search, Pageable pageable);
    PartnerDTO findById(Long id);
    PartnerDTO update(Long id, PartnerDTO partnerDTO);
    long count(Search search);
    List<PartnerDTO> findAll(Pageable pageable);
}
