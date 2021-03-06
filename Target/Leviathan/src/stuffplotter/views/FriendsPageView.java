package stuffplotter.views;

import java.util.List;

import stuffplotter.bindingcontracts.AccountModel;
import stuffplotter.presenters.FriendsPagePresenter.FriendsView;
import stuffplotter.shared.Account;
import stuffplotter.shared.AccountStatistic;

import stuffplotter.views.friends.FriendAchievementPopupPanel;
import stuffplotter.views.friends.FriendPanelView;
import stuffplotter.views.friends.FriendPopupPanel;
import stuffplotter.views.friends.FriendsDisplayPanel;
import stuffplotter.views.friends.PendingFriendPanel;
import stuffplotter.views.util.ScrollDisplayPanel;

import com.google.gwt.event.dom.client.HasAllFocusHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Class to display the friends page view.
 */
public class FriendsPageView extends HorizontalPanel implements FriendsView
{
	private static final int NUMOFCOLUMNS = 1;
	private Button addFriend;
	//private Button searchFriends;
	private TextBox addFriendTextBox;
	private FriendsDisplayPanel friendDisplay;
	private FriendsDisplayPanel pendingFriendDisplay;
	private Label pendingFriendsLabel;
	private Label displayFriendsLabel;
	private FriendPopupPanel popupFriendInfo;
	private FriendAchievementPopupPanel popupFriendAchievements;
	
	/**
	 * Constructor for the FriendsPagePanel.
	 * @pre true;
	 * @post this.isVisible() == true;
	 */
	public FriendsPageView()
	{
		super();
		this.initializeUI();
	}
	
	/**
	 * Helper method to initialize the UI.
	 * @pre true;
	 * @post true;
	 */
	private void initializeUI()
	{
		VerticalPanel buttonHolder = new VerticalPanel();
		HorizontalPanel addFriendPanel = new HorizontalPanel();
		
		this.addFriend = new Button("Add Friend");
		this.addFriendTextBox = new TextBox();
		this.addFriendTextBox.setWidth("250px");
		this.addFriendTextBox.setText("Example: stuffplotter001@gmail.com");
		
		
		//this.searchFriends = new Button("Search Friends");
		this.pendingFriendDisplay = new FriendsDisplayPanel(NUMOFCOLUMNS);
		this.pendingFriendsLabel = new Label("Pending Friends");

		
		addFriendPanel.add(this.addFriend);
		addFriendPanel.add(this.addFriendTextBox);
		buttonHolder.add(addFriendPanel);
		//buttonHolder.add(this.searchFriends);
		buttonHolder.add(pendingFriendsLabel);
		buttonHolder.add(this.pendingFriendDisplay);
		
		
		this.add(buttonHolder);
		this.friendDisplay = new FriendsDisplayPanel(NUMOFCOLUMNS);
		this.displayFriendsLabel = new Label("Display of Friends");
		VerticalPanel friendHolder = new VerticalPanel();
		friendHolder.add(displayFriendsLabel);
		friendHolder.add(this.friendDisplay);
		this.popupFriendInfo = new FriendPopupPanel();
		this.popupFriendInfo.setPopupPosition(displayFriendsLabel.getAbsoluteLeft(), displayFriendsLabel.getAbsoluteTop());
		this.popupFriendAchievements = new FriendAchievementPopupPanel();
		this.popupFriendAchievements.setPopupPosition(displayFriendsLabel.getAbsoluteLeft(), displayFriendsLabel.getAbsoluteTop());
		this.add(friendHolder);
	}
	
	/**
	 * Retrieve the Add Friend button.
	 * @pre true;
	 * @post true;
	 * @return the Add Friend button.
	 */
	public Button getAddFriendBtn()
	{
		return this.addFriend;
	}
	
	/**
	 * Retrieve the Search Friends button.
	 * @pre true;
	 * @post true;
	 * @return the Search Friends button.
	 */
	public Button getSearchFriendsBtn()
	{
		return null;
	}
	
	/**
	 * Retrieve the Friend List panel.
	 * @pre true;
	 * @post true;
	 * @return the Friend List panel.
	 */
	public ScrollDisplayPanel getFriendListPanel()
	{
		return this.friendDisplay;
	}
	

	@Override
	public Widget asWidget()
	{
		return this;
	}

	@Override
	public String getFriendBoxText()
	{
		return this.addFriendTextBox.getText();
	}


	@Override
	public void clearFriendBoxText()
	{
		this.addFriendTextBox.setText("");
		
	}




	@Override
	public void setFriendData(List<AccountModel> models)
	{
		this.friendDisplay.setFriendsData(models);
	}

	@Override
	public HasAllFocusHandlers getFriendTextBox()
	{
		return this.addFriendTextBox;
	}

	@Override
	public List<FriendPanelView> getFriendPanels()
	{
		return this.friendDisplay.getFriendPanels();
	}

	@Override
	public void setPendingData(List<AccountModel> models)
	{
		this.pendingFriendDisplay.setPendingFriendsData(models);
	}

	@Override
	public List<PendingFriendPanel> getPendingFriendPanels()
	{
		return this.pendingFriendDisplay.getPendingFriendPanels();
	}

	@Override
	public FriendPopupPanel getFriendPopupPanel()
	{
		return this.popupFriendInfo;
	}

	@Override
	public FriendAchievementPopupPanel getFriendAchievementPopupPanel()
	{
		return this.popupFriendAchievements;
	}

	@Override
	public void setAccountAndStatsData(Account friendAccount,
			AccountStatistic friendStats)
	{
		this.popupFriendInfo.setAccountAndStatsData(friendAccount, friendStats);
		
	}

	@Override
	public void setStatsData(AccountStatistic stats)
	{
		this.popupFriendAchievements.setStatsData(stats);
		
	}
}
