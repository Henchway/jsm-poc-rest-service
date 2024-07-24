package org.example.jsmpocrestservice.rest.controller;

import lombok.extern.log4j.Log4j2;
import org.example.jsmpocrestservice.rest.exception.NotAuthorizedException;
import org.example.jsmpocrestservice.rest.model.Asset;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/assets")
@Log4j2
public class AssetController {

    @GetMapping
    public ResponseEntity<List<Asset>> getAssets(@RequestParam int numberOfAssets, @RequestParam String token) {

        if (!token.equals("1234")) {
            throw new NotAuthorizedException("Invalid token");
        }

        List<Asset> assetList = new ArrayList<>(numberOfAssets);
        for (int i = 0; i < numberOfAssets; i++) {
            assetList.add(new Asset(i, "asset" + i));
        }
        return ResponseEntity.ok(assetList);

    }

}
