package com.unikom.partnerservice.controller;

import com.unikom.partnerservice.dto.PartnerDTO;
import com.unikom.partnerservice.dto.request.Search;
import com.unikom.partnerservice.dto.response.SuccessResponse;
import com.unikom.partnerservice.dto.response.SuccessResponseList;
import com.unikom.partnerservice.service.impl.PartnerServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Transactional
@RestController
@AllArgsConstructor
@RequestMapping("/partner")
@CrossOrigin(origins = "*")
public class PartnerController {

    private PartnerServiceImpl partnerService;

    @GetMapping
    public ResponseEntity<?> search(@RequestParam(required = false) String code,
                                    @RequestParam(required = false) String name,
                                    @RequestParam(required = false) Integer foundedYear,
                                    @RequestParam(required = false) Integer quantityOfEmployee,
                                    @RequestParam(required = true, defaultValue = "1") int page,
                                    @RequestParam(required = true, defaultValue = "10") int size) {
        Search search = new Search(code, name, foundedYear, quantityOfEmployee);
        Pageable pageable = PageRequest.of(page - 1, size);

        return new ResponseEntity<>(new SuccessResponseList(1, partnerService.count(search), partnerService.search(search, pageable)), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return new ResponseEntity<>(new SuccessResponse(1, partnerService.findById(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid PartnerDTO partner) {
        return new ResponseEntity<>(new SuccessResponse(1, partnerService.save(partner)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody PartnerDTO partner) {
        return new ResponseEntity<>(new SuccessResponse(1, partnerService.update(id, partner)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return new ResponseEntity<>(new SuccessResponse(1, partnerService.delete(id)), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        Search search = new Search();
        long totalRecord = partnerService.count(search);
        Pageable pageable = PageRequest.of(0, (int) totalRecord);
        return new ResponseEntity<>(new SuccessResponseList(1, partnerService.count(search), partnerService.search(search, pageable)), HttpStatus.OK);
    }


}
