import { initializeApp } from "https://www.gstatic.com/firebasejs/9.19.1/firebase-app.js";
import { getMessaging , getToken } from "https://www.gstatic.com/firebasejs/9.19.1/firebase-messaging.js"

const firebaseConfig = {
    apiKey: "AIzaSyBUAho5NgRVGyOeZVKxj6Ir4JlBHfUdfdQ",
    authDomain: "laundry-project-32172.firebaseapp.com",
    projectId: "laundry-project-32172",
    storageBucket: "laundry-project-32172.appspot.com",
    messagingSenderId: "111109128904",
    appId: "1:111109128904:web:7ea1c0b4ca5842aad25bfd",
    measurementId: "G-L907N5VZV5"
};

function requestPermission(clientCode) {
    Notification.requestPermission().then((permission) => {
        if(permission === "granted") {
            const app = initializeApp(firebaseConfig);

            const messaging = getMessaging(app);
            getToken(messaging, {
                vapidKey:
                    "BJBROJjxnPl5mxIQF1ywMvnhNWm-m92SiZ-3d4dC9JJfiLFgxMfPmSBvUQwwZFj_PjITckv-CxsFuyyXXdZRDUA",
            }).then((currentToken) => {
                if(currentToken) {
                    $.ajax({
                            "url": "/saveToken",
                            "method": "POST",
                            "timeout": 0,
                            "headers": {
                                "Content-Type": "application/json"
                            },
                            "data": JSON.stringify({
                                "clientToken": currentToken,
                                "clientCode": clientCode
                            }),
                        }
                    ).done(function (response) {
                        console.log(response);
                    });
                } else {
                    console.log("ㅜㅜ");
                }
            });
        } else {
            console.log("ㅠㅠ");
        }
    });
}

requestPermission();