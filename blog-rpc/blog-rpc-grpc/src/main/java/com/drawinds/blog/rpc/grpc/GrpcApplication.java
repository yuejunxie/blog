package com.drawinds.blog.rpc.grpc;

import com.drawinds.blog.rpc.grpc.common.PageParam;
import com.drawinds.blog.rpc.grpc.common.Pagination;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/2/23 13:32
 * Description:
 */
@Slf4j
@SpringBootApplication
public class GrpcApplication {

    public static void main(String[] args) throws IOException {
        PageParam pageParam = PageParam.newBuilder()
                .setPageNo(1).setPageSize(50).build();
        Pagination pagination = Pagination.newBuilder()
//                .setDetails(0, Any.newBuilder()..build())
                .setPageParam(pageParam).setMessage("yes")
                .addRows("3").addRows("ad").build();

        FileOutputStream fos = new FileOutputStream("D:\\proto-1");
        pagination.writeTo(fos);

        pagination = Pagination.parseFrom(new FileInputStream("D:\\proto-1"));
        log.info(pagination.toString());

    }
}
