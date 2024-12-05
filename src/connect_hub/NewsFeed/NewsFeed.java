/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect_hub.NewsFeed;

import connect_hub.ContentCreation.Content;
import connect_hub.ContentCreation.Post;
import connect_hub.ContentCreation.Story;
import connect_hub.ContentCreation.ContentRepository;
import connect_hub.FriendManagement.FriendManagement;
import connect_hub.UserManagement.UserDetails;

import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.time.LocalDateTime;

/**
 *
 * @author Karen Amgad
 */
public class NewsFeed {

    private FriendManagement friendManagement;
    private ContentRepository contentRepository;

    public NewsFeed(FriendManagement friendManagement, String contentFilePath) {
        this.friendManagement = friendManagement;
        this.contentRepository = new ContentRepository(contentFilePath);
    }

    public Set<UserDetails> ShowSuggestions(UserDetails currentUser) {
        return friendManagement.Suggestions(currentUser);
    }

    //This Class is for displaying the Status of the Friends in the User's Friend List
    public void displayFriendStatuses(UserDetails currentUser) {
        for (UserDetails friend : currentUser.getFriends()) {
            System.out.println(friend.getUserName() + " is " + friend.getStatus());
        }
    }

    public ArrayList<Post> getPosts(UserDetails currentUser) {
        ArrayList<Content> allContent = contentRepository.loadContents();
        ArrayList<Post> posts = new ArrayList<>();

        for (Content content : allContent) {
            if (content instanceof Post) {
                Post post = (Post) content;
                UserDetails u = new UserDetails();
                for (UserDetails user: currentUser.getFriends())
                {
                    if(user.getUserId().equals(post.getAuthorId()))
                    {
                        u = user;
                        break;
                    }
                }
                if (currentUser.getFriends().contains(u) || post.getAuthorId().equals(currentUser.getUserId())) {
                    posts.add(post);
                }
            }
        }

        posts.sort(Comparator.comparing(Post::getTimestamp).reversed());
        return posts;
    }

    public ArrayList<Story> getStories(UserDetails currentUser) {
        ArrayList<Content> allContent = contentRepository.loadContents();
        ArrayList<Story> stories = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();

        for (Content content : allContent) {
            if (content instanceof Story) {
                Story story = (Story) content;
                UserDetails u = new UserDetails();
                for (UserDetails user: currentUser.getFriends())
                {
                    if(user.getUserId().equals(story.getAuthorId()))
                    {
                        u = user;
                        break;
                    }
                }
                if ((currentUser.getFriends().contains(u) || story.getAuthorId().equals(currentUser.getUserId())) && !story.isExpired()) {
                    stories.add(story);
                }
            }
        }

        stories.sort(Comparator.comparing(Story::getTimestamp).reversed());
        return stories;
    }

    public void displayNewsFeed(UserDetails currentUser) {
        System.out.println("Stories:");
        ArrayList<Story> stories = getStories(currentUser);
        for (Story story : stories) {
            System.out.println(story.getAuthorId() + " posted a story: " + story.getCaption());
        }

        System.out.println("\nPosts:");
        List<Post> posts = getPosts(currentUser);
        for (Post post : posts) {
            System.out.println(post.getAuthorId() + " posted: " + post.getCaption());
        }
    }
}
