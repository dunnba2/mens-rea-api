package com.revature.controllers;

import com.revature.services.MediaService;

public class MediaController {

    private MediaService mediaService;

    public MediaController(MediaService service) {
        this.mediaService = service;
    }
}
