package com.streetcat.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {
	
	@Value("${naver.map.client-id}")
    private String naverMapClientId;

	// 지도 표시
    @GetMapping("/map")
    public String mapPage(Model model) {
        model.addAttribute("naverMapClientId", naverMapClientId);
        return "/map";
    }
}
