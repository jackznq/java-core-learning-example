package org.javacore.pbrpc.service.impl;


import org.javacore.pbrpc.PbRpcDemo;
import org.javacore.pbrpc.service.DemoService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: DemoServiceImpl <br/>
 * Function: demo服务端
 *
 * @author Zhang Xu
 */
public class DemoServiceImpl implements DemoService {

    /**
     * 默认返回，暂时无用
     */
    @SuppressWarnings("unused")
    private static final User DEFAULT_USER = new User(1, "name-", User.Gender.MALE);

    /**
     */
    @Override
    public PbRpcDemo.DemoResponse doSmth(PbRpcDemo.DemoRequest req) {
        User user = cachedUsers.get(req.getUserId());
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        PbRpcDemo.DemoResponse.Builder builder = PbRpcDemo.DemoResponse.newBuilder();
        builder.setUserId(user.getUserId());
        builder.setUserName(user.getUserName());
        if (user.getGender().equals(User.Gender.MALE)) {
            builder.setGenderType(PbRpcDemo.DemoResponse.GenderType.MALE);
        } else {
            builder.setGenderType(PbRpcDemo.DemoResponse.GenderType.FEMALE);
        }
        return builder.build();
    }

    @Override
    public PbRpcDemo.DemoResponse doSmthTimeout(PbRpcDemo.DemoRequest req) {
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return doSmth(req);
    }

    /**
     */
    @Override
    public PbRpcDemo.DemoBatchResponse doSmthBatch(PbRpcDemo.DemoBatchRequest req) {
        int requestSize = req.getRequestSize();
        PbRpcDemo.DemoBatchResponse.Builder builder = PbRpcDemo.DemoBatchResponse.newBuilder();
        List<PbRpcDemo.DemoText> list = new ArrayList<PbRpcDemo.DemoText>(requestSize);
        for (int i = 0; i < requestSize; i++) {
            PbRpcDemo.DemoText.Builder demoText = PbRpcDemo.DemoText.newBuilder();
            demoText.setText(req.getText());
            list.add(demoText.build());
        }
        builder.addAllTexts(list);
        return builder.build();
    }

    /**
     * 缓存的user列表
     */
    private Map<Integer, User> cachedUsers = new HashMap<Integer, User>();

    /**
     * 初始化
     */
    {
        for (int i = 0; i < 10; i++) {
            User user = new User(i, "name-" + i, i % 2 == 0 ? User.Gender.MALE : User.Gender.FEMALE);
            cachedUsers.put(user.getUserId(), user);
        }
    }

    /**
     * ClassName: User <br/>
     * Function: 用户VO
     *
     * @author Zhang Xu
     */
    static class User {

        /**
         * userid
         */
        private int userId;

        /**
         * username
         */
        private String userName;

        /**
         * 性别
         */
        private Gender gender;

        /**
         * Creates a new instance of User.
         *
         * @param userId
         * @param userName
         * @param gender
         */
        public User(int userId, String userName, Gender gender) {
            super();
            this.userId = userId;
            this.userName = userName;
            this.gender = gender;
        }

        /**
         * 性别枚举
         */
        public static enum Gender {
            MALE, FEMALE;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public Gender getGender() {
            return gender;
        }

        public void setGender(Gender gender) {
            this.gender = gender;
        }

    }

}
