package com.drawinds.blog.portal.share.restful;

import com.drawinds.blog.portal.share.model.NetworkFile;
import com.drawinds.blog.portal.share.service.MixService;
import com.drawinds.blog.portal.share.service.NetworkFileService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2018/12/29 22:38
 * Description:
 */
@RestController
@RequestMapping(path = "/network/file", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class NetworkFileRestful {

    @Autowired
    private NetworkFileService networkFileService;

    @Autowired
    private MixService mixService;

    @GetMapping
    public NetworkFile getNetworkFileById(String id) {
        return networkFileService.getNetworkFileById(id);
    }

    @PostMapping
    public int addNetworkFile() {
        NetworkFile networkFile = new NetworkFile("软件目录", "DISK", "D://Program Files");
        return networkFileService.addNetworkFile(networkFile);
    }

    @PostMapping("/mix")
    public void mix(){
        mixService.mixAdd();
    }
}
