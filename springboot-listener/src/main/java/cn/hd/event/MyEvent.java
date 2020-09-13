package cn.hd.event;

import cn.hd.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件
 */
@Setter
@Getter
public class MyEvent extends ApplicationEvent {
    private User user;

    public MyEvent(Object source, User user) {
        super(source);
        this.user = user;
    }
}
