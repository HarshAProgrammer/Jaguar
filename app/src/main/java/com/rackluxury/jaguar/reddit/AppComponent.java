package com.rackluxury.jaguar.reddit;

import javax.inject.Singleton;

import dagger.Component;
import com.rackluxury.jaguar.reddit.activities.RedditAccountPostsActivity;
import com.rackluxury.jaguar.reddit.activities.AccountSavedThingActivity;
import com.rackluxury.jaguar.reddit.activities.AnonymousSubscriptionsActivity;
import com.rackluxury.jaguar.reddit.activities.RedditCommentActivity;
import com.rackluxury.jaguar.reddit.activities.CreateMultiRedditActivity;
import com.rackluxury.jaguar.reddit.activities.CustomThemeListingActivity;
import com.rackluxury.jaguar.reddit.activities.RedditCustomThemePreviewActivity;
import com.rackluxury.jaguar.reddit.activities.CustomizePostFilterActivity;
import com.rackluxury.jaguar.reddit.activities.RedditCustomizeThemeActivity;
import com.rackluxury.jaguar.reddit.activities.RedditEditCommentActivity;
import com.rackluxury.jaguar.reddit.activities.RedditEditMultiRedditActivity;
import com.rackluxury.jaguar.reddit.activities.RedditEditPostActivity;
import com.rackluxury.jaguar.reddit.activities.FetchRandomSubredditOrPostActivity;
import com.rackluxury.jaguar.reddit.activities.RedditFilteredPostsActivity;
import com.rackluxury.jaguar.reddit.activities.FullMarkdownActivity;
import com.rackluxury.jaguar.reddit.activities.GiveAwardActivity;
import com.rackluxury.jaguar.reddit.activities.RedditInboxActivity;
import com.rackluxury.jaguar.reddit.activities.RedditLinkResolverActivity;
import com.rackluxury.jaguar.reddit.activities.RedditLockScreenActivity;
import com.rackluxury.jaguar.reddit.activities.RedditLoginActivity;
import com.rackluxury.jaguar.reddit.activities.RedditMainActivity;
import com.rackluxury.jaguar.reddit.activities.MultiredditSelectionActivity;
import com.rackluxury.jaguar.reddit.activities.RedditPostFilterPreferenceActivity;
import com.rackluxury.jaguar.reddit.activities.PostFilterUsageListingActivity;
import com.rackluxury.jaguar.reddit.activities.RedditPostGalleryActivity;
import com.rackluxury.jaguar.reddit.activities.RedditPostImageActivity;
import com.rackluxury.jaguar.reddit.activities.RedditPostLinkActivity;
import com.rackluxury.jaguar.reddit.activities.RedditPostTextActivity;
import com.rackluxury.jaguar.reddit.activities.RedditPostVideoActivity;
import com.rackluxury.jaguar.reddit.activities.RedditRPANActivity;
import com.rackluxury.jaguar.reddit.activities.RedditRulesActivity;
import com.rackluxury.jaguar.reddit.activities.RedditSearchActivity;
import com.rackluxury.jaguar.reddit.activities.RedditSearchUsersResultActivity;
import com.rackluxury.jaguar.reddit.activities.RedditSettingsActivity;
import com.rackluxury.jaguar.reddit.activities.RedditSubredditMultiselectionActivity;
import com.rackluxury.jaguar.reddit.activities.RedditTrendingActivity;
import com.rackluxury.jaguar.reddit.activities.RedditViewPostDetailActivity;
import com.rackluxury.jaguar.reddit.activities.RedditViewPrivateMessagesActivity;
import com.rackluxury.jaguar.reddit.activities.RedditViewRedditGalleryActivity;
import com.rackluxury.jaguar.reddit.activities.RedditViewVideoActivity;
import com.rackluxury.jaguar.reddit.activities.ReportActivity;
import com.rackluxury.jaguar.reddit.activities.SearchResultActivity;
import com.rackluxury.jaguar.reddit.activities.RedditSearchSubredditsResultActivity;
import com.rackluxury.jaguar.reddit.activities.SelectUserFlairActivity;
import com.rackluxury.jaguar.reddit.activities.SelectedSubredditsAndUsersActivity;
import com.rackluxury.jaguar.reddit.activities.SendPrivateMessageActivity;
import com.rackluxury.jaguar.reddit.activities.RedditSubmitCrosspostActivity;
import com.rackluxury.jaguar.reddit.activities.RedditSubredditSelectionActivity;
import com.rackluxury.jaguar.reddit.activities.RedditSubscribedThingListingActivity;
import com.rackluxury.jaguar.reddit.activities.SuicidePreventionActivity;
import com.rackluxury.jaguar.reddit.activities.ViewImageOrGifActivity;
import com.rackluxury.jaguar.reddit.activities.RedditViewImgurMediaActivity;
import com.rackluxury.jaguar.reddit.activities.RedditViewMultiRedditDetailActivity;
import com.rackluxury.jaguar.reddit.activities.RedditViewSubredditDetailActivity;
import com.rackluxury.jaguar.reddit.activities.RedditViewUserDetailActivity;
import com.rackluxury.jaguar.reddit.activities.RedditWebViewActivity;
import com.rackluxury.jaguar.reddit.bottomsheetfragments.FlairBottomSheetFragment;
import com.rackluxury.jaguar.reddit.fragments.CommentsListingFragment;
import com.rackluxury.jaguar.reddit.fragments.FollowedUsersListingFragment;
import com.rackluxury.jaguar.reddit.fragments.InboxFragment;
import com.rackluxury.jaguar.reddit.fragments.MultiRedditListingFragment;
import com.rackluxury.jaguar.reddit.fragments.PostFragment;
import com.rackluxury.jaguar.reddit.fragments.SidebarFragment;
import com.rackluxury.jaguar.reddit.fragments.SubredditListingFragment;
import com.rackluxury.jaguar.reddit.fragments.SubscribedSubredditsListingFragment;
import com.rackluxury.jaguar.reddit.fragments.UserListingFragment;
import com.rackluxury.jaguar.reddit.fragments.ViewImgurImageFragment;
import com.rackluxury.jaguar.reddit.fragments.ViewImgurVideoFragment;
import com.rackluxury.jaguar.reddit.fragments.ViewPostDetailFragment;
import com.rackluxury.jaguar.reddit.fragments.ViewRPANBroadcastFragment;
import com.rackluxury.jaguar.reddit.fragments.ViewRedditGalleryImageOrGifFragment;
import com.rackluxury.jaguar.reddit.fragments.ViewRedditGalleryVideoFragment;
import com.rackluxury.jaguar.reddit.services.RedditDownloadMediaService;
import com.rackluxury.jaguar.reddit.services.RedditDownloadRedditVideoService;
import com.rackluxury.jaguar.reddit.services.MaterialYouService;
import com.rackluxury.jaguar.reddit.services.SubmitPostService;
import com.rackluxury.jaguar.reddit.settings.AdvancedPreferenceFragment;
import com.rackluxury.jaguar.reddit.settings.CrashReportsFragment;
import com.rackluxury.jaguar.reddit.settings.CustomizeBottomAppBarFragment;
import com.rackluxury.jaguar.reddit.settings.CustomizeMainPageTabsFragment;
import com.rackluxury.jaguar.reddit.settings.DownloadLocationPreferenceFragment;
import com.rackluxury.jaguar.reddit.settings.GesturesAndButtonsPreferenceFragment;
import com.rackluxury.jaguar.reddit.settings.MainPreferenceFragment;
import com.rackluxury.jaguar.reddit.settings.MiscellaneousPreferenceFragment;
import com.rackluxury.jaguar.reddit.settings.NotificationPreferenceFragment;
import com.rackluxury.jaguar.reddit.settings.NsfwAndSpoilerFragment;
import com.rackluxury.jaguar.reddit.settings.PostHistoryFragment;
import com.rackluxury.jaguar.reddit.settings.SecurityPreferenceFragment;
import com.rackluxury.jaguar.reddit.settings.ThemePreferenceFragment;
import com.rackluxury.jaguar.reddit.settings.TranslationFragment;
import com.rackluxury.jaguar.reddit.settings.VideoPreferenceFragment;

@Singleton
@Component(modules = com.rackluxury.jaguar.reddit.AppModule.class)
public interface AppComponent {
    void inject(RedditMainActivity redditMainActivity);

    void inject(RedditLoginActivity redditLoginActivity);

    void inject(PostFragment postFragment);

    void inject(SubredditListingFragment subredditListingFragment);

    void inject(UserListingFragment userListingFragment);

    void inject(RedditViewPostDetailActivity redditViewPostDetailActivity);

    void inject(RedditViewSubredditDetailActivity redditViewSubredditDetailActivity);

    void inject(RedditViewUserDetailActivity redditViewUserDetailActivity);

    void inject(RedditCommentActivity redditCommentActivity);

    void inject(RedditSubscribedThingListingActivity redditSubscribedThingListingActivity);

    void inject(RedditPostTextActivity redditPostTextActivity);

    void inject(SubscribedSubredditsListingFragment subscribedSubredditsListingFragment);

    void inject(RedditPostLinkActivity redditPostLinkActivity);

    void inject(RedditPostImageActivity redditPostImageActivity);

    void inject(RedditPostVideoActivity redditPostVideoActivity);

    void inject(FlairBottomSheetFragment flairBottomSheetFragment);

    void inject(RedditRulesActivity redditRulesActivity);

    void inject(CommentsListingFragment commentsListingFragment);

    void inject(SubmitPostService submitPostService);

    void inject(RedditFilteredPostsActivity redditFilteredPostsActivity);

    void inject(SearchResultActivity searchResultActivity);

    void inject(RedditSearchSubredditsResultActivity redditSearchSubredditsResultActivity);

    void inject(FollowedUsersListingFragment followedUsersListingFragment);

    void inject(RedditSubredditSelectionActivity redditSubredditSelectionActivity);

    void inject(RedditEditPostActivity redditEditPostActivity);

    void inject(RedditEditCommentActivity redditEditCommentActivity);

    void inject(RedditAccountPostsActivity redditAccountPostsActivity);

    void inject(com.rackluxury.jaguar.reddit.PullNotificationWorker pullNotificationWorker);

    void inject(RedditInboxActivity redditInboxActivity);

    void inject(NotificationPreferenceFragment notificationPreferenceFragment);

    void inject(RedditLinkResolverActivity redditLinkResolverActivity);

    void inject(RedditSearchActivity redditSearchActivity);

    void inject(RedditSettingsActivity redditSettingsActivity);

    void inject(MainPreferenceFragment mainPreferenceFragment);

    void inject(AccountSavedThingActivity accountSavedThingActivity);

    void inject(ViewImageOrGifActivity viewGIFActivity);

    void inject(RedditViewMultiRedditDetailActivity redditViewMultiRedditDetailActivity);

    void inject(RedditViewVideoActivity redditViewVideoActivity);

    void inject(GesturesAndButtonsPreferenceFragment gesturesAndButtonsPreferenceFragment);

    void inject(CreateMultiRedditActivity createMultiRedditActivity);

    void inject(RedditSubredditMultiselectionActivity redditSubredditMultiselectionActivity);

    void inject(ThemePreferenceFragment themePreferenceFragment);

    void inject(RedditCustomizeThemeActivity redditCustomizeThemeActivity);

    void inject(CustomThemeListingActivity customThemeListingActivity);

    void inject(SidebarFragment sidebarFragment);

    void inject(AdvancedPreferenceFragment advancedPreferenceFragment);

    void inject(RedditCustomThemePreviewActivity redditCustomThemePreviewActivity);

    void inject(RedditEditMultiRedditActivity redditEditMultiRedditActivity);

    void inject(SelectedSubredditsAndUsersActivity selectedSubredditsAndUsersActivity);

    void inject(ReportActivity reportActivity);

    void inject(RedditViewImgurMediaActivity redditViewImgurMediaActivity);

    void inject(ViewImgurVideoFragment viewImgurVideoFragment);

    void inject(RedditDownloadRedditVideoService redditDownloadRedditVideoService);

    void inject(MultiRedditListingFragment multiRedditListingFragment);

    void inject(InboxFragment inboxFragment);

    void inject(RedditViewPrivateMessagesActivity redditViewPrivateMessagesActivity);

    void inject(SendPrivateMessageActivity sendPrivateMessageActivity);

    void inject(VideoPreferenceFragment videoPreferenceFragment);

    void inject(RedditViewRedditGalleryActivity redditViewRedditGalleryActivity);

    void inject(ViewRedditGalleryVideoFragment viewRedditGalleryVideoFragment);

    void inject(CustomizeMainPageTabsFragment customizeMainPageTabsFragment);

    void inject(RedditDownloadMediaService redditDownloadMediaService);

    void inject(DownloadLocationPreferenceFragment downloadLocationPreferenceFragment);

    void inject(RedditSubmitCrosspostActivity redditSubmitCrosspostActivity);

    void inject(FullMarkdownActivity fullMarkdownActivity);

    void inject(SelectUserFlairActivity selectUserFlairActivity);

    void inject(SecurityPreferenceFragment securityPreferenceFragment);

    void inject(NsfwAndSpoilerFragment nsfwAndSpoilerFragment);

    void inject(CustomizeBottomAppBarFragment customizeBottomAppBarFragment);

    void inject(GiveAwardActivity giveAwardActivity);

    void inject(TranslationFragment translationFragment);

    void inject(FetchRandomSubredditOrPostActivity fetchRandomSubredditOrPostActivity);

    void inject(MiscellaneousPreferenceFragment miscellaneousPreferenceFragment);

    void inject(CustomizePostFilterActivity customizePostFilterActivity);

    void inject(PostHistoryFragment postHistoryFragment);

    void inject(RedditPostFilterPreferenceActivity redditPostFilterPreferenceActivity);

    void inject(PostFilterUsageListingActivity postFilterUsageListingActivity);

    void inject(RedditSearchUsersResultActivity redditSearchUsersResultActivity);

    void inject(MultiredditSelectionActivity multiredditSelectionActivity);

    void inject(ViewImgurImageFragment viewImgurImageFragment);

    void inject(ViewRedditGalleryImageOrGifFragment viewRedditGalleryImageOrGifFragment);

    void inject(ViewPostDetailFragment viewPostDetailFragment);

    void inject(SuicidePreventionActivity suicidePreventionActivity);

    void inject(RedditWebViewActivity redditWebViewActivity);

    void inject(CrashReportsFragment crashReportsFragment);

    void inject(AnonymousSubscriptionsActivity anonymousSubscriptionsActivity);

    void inject(RedditLockScreenActivity redditLockScreenActivity);

    void inject(MaterialYouService materialYouService);

    void inject(RedditRPANActivity redditRpanActivity);

    void inject(ViewRPANBroadcastFragment viewRPANBroadcastFragment);

    void inject(RedditPostGalleryActivity redditPostGalleryActivity);

    void inject(RedditTrendingActivity redditTrendingActivity);
}
