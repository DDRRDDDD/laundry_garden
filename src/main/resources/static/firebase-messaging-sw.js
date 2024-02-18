self.addEventListener('push', event => {
    const data = event.data.json();
    const title = data.notification.title;
    const body = data.notification.body;
    event.waitUntil(
        self.registration.showNotification(title, {
            body: body,
            icon: 'https://laundrygarden.store/images/pepe.jpeg',
            badge: 'https://laundrygarden.store/images/pepe.jpeg'
        })
    )
});

self.addEventListener("notificationclick", function (event) {
    const url = "https://laundrygarden.store";
    event.notification.close();
    event.waitUntil(clients.openWindow(url));
});

