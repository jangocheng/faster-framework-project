package cn.org.faster.framework.grpc.spring.boot.autoconfigure.properties;

import cn.org.faster.framework.grpc.client.model.ChannelProperty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangbowen
 * @since 2019/1/15
 */
@ConfigurationProperties(prefix = "faster.grpc")
@Data
public class GrpcProperties {
    /**
     * 是否开启grpc：true/false
     */
    private boolean enabled;
    /**
     * 客户端配置
     */
    private Client client = new Client();
    /**
     * 服务端配置
     */
    private Server server = new Server();

    @ConfigurationProperties(prefix = "faster.grpc.client")
    @Data
    public static class Client {
        /**
         * 是否开启客户端：true/false
         */
        private boolean enabled;
        /**
         * 服务列表
         */
        private Map<String, ChannelProperty> services = new HashMap<>();
    }

    @ConfigurationProperties(prefix = "faster.grpc.server")
    @Data
    public static class Server {

        /**
         * 是否开启服务端：true/false
         */
        private boolean enabled;

        /**
         * 端口号
         */
        private int port = 50051;
    }
}
