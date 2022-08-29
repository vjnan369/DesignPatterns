package com.solidPrinciples.Liskov;

//https://medium.com/@javatechie/solid-design-principle-java-ae96a48db97
public class Medium2 {}
//we can consider Facebook is complete substitute of SocialMedia class , both can be replaced without any interrupt
interface SocialMedia {
    public void chatWithFriends();
    public void publishPosts();
    public void sendPhotosAndVideos();
    public void groupVideoCall();
}

class FaceBook implements SocialMedia{

    @Override
    public void chatWithFriends() {}

    @Override
    public void publishPosts() {}

    @Override
    public void sendPhotosAndVideos() {}

    @Override
    public void groupVideoCall() {}
}

//due to publishPost() method whatsapp child is not substitute of parents SocialMedia
//Similarly instagram doesn’t support groupVideoCall() feature so we say instagram child is not substitute of parents SocialMedia
class WhatsApp implements SocialMedia{

    @Override
    public void chatWithFriends() {

    }

    @Override
    public void publishPosts() {
        //Not applicable
    }

    @Override
    public void sendPhotosAndVideos() {

    }

    @Override
    public void groupVideoCall() {

    }
}

//Solution
interface SocialMedia2 {
    public void chatWithFriend();
    public void sendPhotosAndVideos();
}

interface SocialPostAndMediaManager{
    public void publishPost(Object post);
}

interface VideoCallManager {
    public void groupVideoCall(String... users);
}

//instagram doesn’t support video call feature so instagram implementation can be design something like this
class Instagram implements SocialMedia2, SocialPostAndMediaManager {

    @Override
    public void chatWithFriend() {

    }

    @Override
    public void sendPhotosAndVideos() {

    }

    @Override
    public void publishPost(Object post) {

    }
}
