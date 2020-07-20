package com.crazy.article.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crazy.article.entity.MessageEntity;
import com.crazy.article.mapper.MessageMapper;
import com.crazy.article.service.MessageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author shiyi
 * @since 2020-07-17
 *
 */
@Service
@Transactional
public class MessageServiceImpl extends ServiceImpl<MessageMapper, MessageEntity> implements MessageService {

    @Override
    public List<MessageEntity> queryMessage(String code) {
        /*
         * 1.查询出所有留言
         * 2.查询出指定code的留言为msgList
         * 3.遍历msgList，找出它所有的子集
         * 4.如果需要返回的是集合不是树
         * 5.把树转换成集合
         */
        List<MessageEntity> messageList = new ArrayList<>();
        // 查询出所有留言
        List<MessageEntity> allList = this.list();

        if (allList != null && list().size() > 0) {
            // 筛选出要指定的人
            List<MessageEntity> msgList = allList.stream().filter(x -> x.getCode().equals(code)).collect(Collectors.toList());
            if (msgList.size() > 0) {
                // 遍历msgList，找出它所有的子集
                for (MessageEntity msgEntity : msgList) {
                    // 把集合转换成树结构
                    List<MessageEntity> treeList = messageListToTree(msgEntity, allList);
                    messageList.addAll(treeList);
                }
            }
        }

//        return treeToList(messageList);
        return messageList;
    }

    private List<MessageEntity> treeToList(List<MessageEntity> messageList) {
        List<MessageEntity> result = new ArrayList<>();
        for (MessageEntity entity : messageList) {
            result.add(entity);
            List<MessageEntity> childMsg = entity.getChildMsg();
            if (childMsg != null && childMsg.size() > 0) {
                List<MessageEntity> entityList = this.treeToList(childMsg);
                result.addAll(entityList);
            }
        }
        if (result.size() > 0) {
            for (MessageEntity entity : result) {
                entity.setChildMsg(null);
            }
        }
        return result;
    }

    private List<MessageEntity> messageListToTree(MessageEntity msgEntity, List<MessageEntity> allList) {
        List<MessageEntity> msgList = new ArrayList<>();
        for (MessageEntity messageEntity : allList) {
            if (messageEntity.getParentId().equals(msgEntity.getId())) {
                if (msgEntity.getChildMsg() == null) {
                    msgEntity.setChildMsg(new ArrayList<>());
                }
                msgEntity.getChildMsg().add(findChild(messageEntity, allList));
            }
        }
        msgList.add(msgEntity);
        return msgList;
    }

    private MessageEntity findChild(MessageEntity messageEntity, List<MessageEntity> allList) {
        for (MessageEntity entity : allList) {
            if (entity.getParentId().equals(messageEntity.getId())) {
               if (messageEntity.getChildMsg() == null) {
                   messageEntity.setChildMsg(new ArrayList<>());
               }
               messageEntity.getChildMsg().add(findChild(entity, allList));
            }
        }
        return messageEntity;
    }
}
