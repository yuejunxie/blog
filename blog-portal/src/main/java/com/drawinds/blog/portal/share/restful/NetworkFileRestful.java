package com.drawinds.blog.portal.share.restful;

import com.drawinds.blog.portal.share.model.NetworkFile;
import com.drawinds.blog.portal.share.service.NetworkFileService;
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

    @GetMapping
    public NetworkFile getNetworkFileById(String id) {
        return networkFileService.getNetworkFileById(id);
    }

    @PostMapping
    public int addNetworkFile() {
        NetworkFile networkFile = new NetworkFile("1224s3s56", "软件目录", "DISK", "D://Program Files", new Date(), "xuanyijun", new Date(), "xuanyijun", true);
        return networkFileService.addNetworkFile(networkFile);
    }
}
