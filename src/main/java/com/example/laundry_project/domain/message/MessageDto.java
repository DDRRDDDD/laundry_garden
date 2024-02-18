package com.example.laundry_project.domain.message;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MessageDto {

    private Message message;

    @Getter
    @NoArgsConstructor
    public class Message {

        private String token;
        private Notification notification;

        @Getter
        @NoArgsConstructor
        public class Notification {
            private String title;
            private String body;
        }
    }
}
