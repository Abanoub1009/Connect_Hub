package connect_hub.NewsFeed;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ConnectHubGUI extends JFrame {

    private JPanel sidePanel, mainPanel;
    private JButton btnFriendManagement, btnNewsFeed, btnContentCreation, btnRefresh;
    private JPanel friendManagementPanel, newsFeedPanel, contentCreationPanel;

    public ConnectHubGUI() {
        // Setting up the main frame
        setTitle("Connect Hub");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Main layout
        setLayout(new BorderLayout());

        // Side Panel for Navigation
        sidePanel = new JPanel();
        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
        sidePanel.setBackground(new Color(51, 153, 255));

        btnFriendManagement = new JButton("Friend Management");
        btnNewsFeed = new JButton("News Feed");
        btnContentCreation = new JButton("Content Creation");
        btnRefresh = new JButton("Refresh");

        // Adding action listeners to buttons
        btnFriendManagement.addActionListener((ActionEvent e) -> {
            showFriendManagement();
        });

        btnNewsFeed.addActionListener((ActionEvent e) -> {
            showNewsFeed();
        });

        btnContentCreation.addActionListener((ActionEvent e) -> {
            showContentCreation();
        });

        // Adding buttons to the side panel
        sidePanel.add(btnFriendManagement);
        sidePanel.add(btnNewsFeed);
        sidePanel.add(btnContentCreation);
        sidePanel.add(btnRefresh);

        // Main panel for content display
        mainPanel = new JPanel();
        mainPanel.setLayout(new CardLayout());

        // Panels for each section
        friendManagementPanel = createFriendManagementPanel();
        newsFeedPanel = createNewsFeedPanel();
        contentCreationPanel = createContentCreationPanel();

        // Adding all panels to the main panel (CardLayout allows switching between them)
        mainPanel.add(friendManagementPanel, "Friend Management");
        mainPanel.add(newsFeedPanel, "News Feed");
        mainPanel.add(contentCreationPanel, "Content Creation");

        // Add the side panel and main panel to the frame
        add(sidePanel, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);
    }

    // Method to show Friend Management panel
    private void showFriendManagement() {
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.show(mainPanel, "Friend Management");
    }

    // Method to show News Feed panel
    private void showNewsFeed() {
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.show(mainPanel, "News Feed");
    }

    // Method to show Content Creation panel
    private void showContentCreation() {
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.show(mainPanel, "Content Creation");
    }

    // Panel for Friend Management
    private JPanel createFriendManagementPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Label for the title
        JLabel label = new JLabel("Friend Management", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));

        // Button to show friend requests (Example functionality)
        JButton btnViewRequests = new JButton("View Friend Requests");
        JButton btnSendRequest = new JButton("Send Friend Request");
        JButton btnBlockFriend = new JButton("Block Friend");

        // Add buttons to the panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnViewRequests);
        buttonPanel.add(btnSendRequest);
        buttonPanel.add(btnBlockFriend);

        // Create a friend list (for display purpose)
        String[] columns = {"Friend Name", "Status"};
        String[][] data = {{"John", "Online"}, {"Doe", "Offline"}}; // Example data
        JTable table = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(table);

        // Adding components to the panel
        panel.add(label, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(scrollPane, BorderLayout.SOUTH);

        return panel;
    }

    // Panel for News Feed
    private JPanel createNewsFeedPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Label for the title
        JLabel label = new JLabel("News Feed", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));

        // Create a list for posts and stories
        JTextArea newsFeedArea = new JTextArea(20, 40);
        newsFeedArea.setText("Recent Posts and Stories will appear here...");
        newsFeedArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(newsFeedArea);

        // Add a refresh button
        btnRefresh.addActionListener((ActionEvent e) -> {
            // Refresh the news feed (for example, by fetching updated data)
            refreshNewsFeed(newsFeedArea);
        });

        // Adding components to the panel
        panel.add(label, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    // Panel for Content Creation
    private JPanel createContentCreationPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Label for the title
        JLabel label = new JLabel("Create New Post/Story", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));

        // Text area for content creation
        JTextArea contentArea = new JTextArea(5, 40);
        contentArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JButton btnPost = new JButton("Post");
        JButton btnStory = new JButton("Post Story");

        // Adding components to the panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnPost);
        buttonPanel.add(btnStory);

        panel.add(label, BorderLayout.NORTH);
        panel.add(new JScrollPane(contentArea), BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    // Method to refresh the News Feed
    private void refreshNewsFeed(JTextArea newsFeedArea) {
        // Fetch the actual posts and stories from your data model (replace this with real data)
        String refreshedContent = "New Posts and Stories:\n";
        refreshedContent += "Post 1: Great day today!\n";
        refreshedContent += "Story 1: Just got back from a trip!\n";

        // Update the news feed area
        newsFeedArea.setText(refreshedContent);
    }

    public static void main(String[] args) {
        // Create and show the GUI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ConnectHubGUI().setVisible(true);
            }
        });
    }
}
