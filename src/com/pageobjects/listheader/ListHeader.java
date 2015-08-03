package com.pageobjects.listheader;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.SafeActions;
import com.sun.mail.handlers.message_rfc822;

public class ListHeader extends SafeActions {
	private WebDriver driver;

	/*
	 * Constructor for the page.
	 */
	public ListHeader(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/*
	 * Locator for ultimate list.
	 */
	private By listRibbon(String list) {
		if (list.equalsIgnoreCase("ultimate"))
			return By
					.xpath("//header[@id='listHead']/div[@id='listData']/div[@class='float relative block white serif tab visible rnkrCRRedBg']/span[@class='inlineBlock txt']");
		// if(list.equalsIgnoreCase("vote"))
		else
			return By
					.xpath("//header[@id='listHead']/div[@id='listData']/div[@class='float relative block white serif tab visible rnkrBlueBg']/span[@class='inlineBlock txt']");
		// if(list.equalsIgnoreCase("vote"))");

	}

	/*
	 * Function to check the presence of ultimate list tag.
	 */
	public boolean isListRibbonPresent(String list) {
		return isElementPresent(listRibbon(list));
	}

	/*
	 * Function to get the text of ultimate list tag.
	 */
	public String getTextOfListRibbon(String list) {
		return safeGetText(listRibbon(list), VERYLONGWAIT);
	}

	/*
	 * Locator for ultimate list.
	 */
	private By getcolorlistRibbon(String list) {
		if (list.equalsIgnoreCase("ultimate"))
			return By
					.xpath("//header[@id='listHead']/div[@id='listData']/div[@class='float relative block white serif tab visible rnkrCRRedBg']");
		else
			return By
					.xpath("//header[@id='listHead']/div[@id='listData']/div[@class='float relative block white serif tab visible rnkrBlueBg']");

	}

	/*
	 * Function to get colour of ultimate list tag.
	 */
	public String getColorOfListRibbon(String list) {
		return driver.findElement(getcolorlistRibbon(list)).getCssValue("background-color");
	}

	/*
	 * Locator for More Info.
	 */
	private By moreInfoLink() {
		return By.xpath("//div[@id='listData']/div[@class='midGrey serif data']/span[@id='listDataMore_trigger']");
	}

	/*
	 * Function to know color of more info link.
	 */
	public String getColorOfMoreInfoLink() {
		return driver.findElement(moreInfoLink()).getCssValue("color");
	}

	/*
	 * Function to check font-style of more info link.
	 */
	public String getFontStyleOfmoreInfoLink() {
		return driver.findElement(moreInfoLink()).getCssValue("font-style");
	}

	/*
	 * Function to make click on more info link.
	 */
	public void clickOnmoreInfoLink() {
		safeJavaScriptClick(moreInfoLink(), SHORTWAIT);
	}

	/*
	 * Locator for more info link box.
	 */
	private By moreInfoBox(String name) {
		if (name.equalsIgnoreCase("breadCrumb"))
			return By
					.xpath("//header[@id='listHead']/div[@id='listDataMore']/span[@id='breadCrumb']");
		else {
			if (name.equalsIgnoreCase("tags"))
				return By
						.xpath("//header[@id='listHead']/div[@id='listDataMore']/span[@id='listTags']");
			else
				return By
						.xpath("//header[@id='listHead']/div[@id='listDataMore']/div[@id='itemCount']");
		}
	}

	/*
	 * Function to check presence of more info box's items.
	 */
	public boolean ismoreInfoBoxItemsPresent(String name) {
		return isElementPresent(moreInfoBox(name));
	}

	/*
	 * Locator for more info box breadcrumb.
	 */
	private By moreInfoBreadCrumb(String breadLinks) {
		return By.xpath("//div[@id='listDataMore']/span[@id='breadCrumb']/a["+ breadLinks + "]");
	}
	/*
	 * Locator for more info box breadcrumb.
	 */
	private By moreInfoBreadCrumbNotclass() {
		return By.xpath("//div[@id='listDataMore']/span[@id='breadCrumb']/a[3]");
	}
	/*
	 * Function to check the presence of home link in breadCrumb in more info
	 * box.
	 */
	public boolean ismoreInfoBreadCrumbNotclassPresent() {
		return isElementPresent(moreInfoBreadCrumbNotclass());
	}
	/*
	 * Function to check the presence of home link in breadCrumb in more info
	 * box.
	 */
	public boolean isMoreInfoBreadCrumbPresent(int breadLinks) {
		return isElementPresent(moreInfoBreadCrumb(breadLinks + ""));
	}

	/*
	 * Function to get href of home link in breadCrumb in more info box.
	 */
	public String getHrefOfMoreInfoBreadCrumb(int breadLinks) {
		return driver.findElement(moreInfoBreadCrumb(breadLinks + "")).getAttribute("href");
	}

	/*
	 * Function to make click on home link in breadCrumb in more info box.
	 */
	public void clickOnMoreInfoBreadCrumb(int breadLinks) {
		safeJavaScriptClick(moreInfoBreadCrumb(breadLinks + ""), VERYLONGWAIT);

	}

	/*
	 * Locator for more info box tags.
	 */
	private By moreInfoTags(String tag) {
		return By
				.xpath("//header[@id='listHead']/div[@id='listDataMore']/span[@id='listTags']/a["
						+ tag + "]");
	}

	/*
	 * Function to get the text of tag.
	 */
	public String getTextOfnextlisttags(int tag) {
		return safeGetText(moreInfoTags(tag + ""), SHORTWAIT);
	}

	/*
	 * Function to check the presence of tags link in more info box.
	 */
	public boolean isMoreInfoTagsPresent(int tag) {
		return isElementPresent(moreInfoTags(tag + ""));
	}

	/*
	 * Function to check whether the tag in more info box is clickable or not.
	 */
	public boolean isMoreInfoTagsClickable(int tag) {
		return isElementClickable(moreInfoTags(tag + ""), VERYLONGWAIT);
	}

	/*
	 * Function to make click on tag link in tag in more info box.
	 */
	public void clickOnMoreInfoTags(int tag) {
		safeJavaScriptClick(moreInfoTags(tag + ""), VERYLONGWAIT);
	}

	/*
	 * Function to get href of tag link in tag in more info box.
	 */
	public String getHrefOfmoreInfoTags(int tag) {
		return driver.findElement(moreInfoTags(tag + "")).getAttribute("href");
	}

	/*
	 * Locator for text of List criteria.
	 */
	private By listCriteriaText(String txt) {
		if (txt.equalsIgnoreCase("criteria"))
			return By
					.xpath("//header[@id='listHead']/div[@id='listDesc']/p/span");
		else
			return By
					.xpath("//header[@id='listHead']/div[@id='listDesc']/p/strong");
	}

	/*
	 * Function to get text of list criteria.
	 */
	public String getTextOfListCriteriaText(String txt) {
		return safeGetText(listCriteriaText(txt), VERYLONGWAIT);
	}

	/*
	 * Function to check the color of text in criteria.
	 */
	public String getColorOflistCriteria(String txt) {
		return driver.findElement(listCriteriaText(txt)).getCssValue("color");
	}

	/*
	 * Function to check the font style of List Criteria heading.
	 */
	public String getFontWeightOfListCriteriaHead(String txt) {
		return driver.findElement(listCriteriaText(txt)).getCssValue(
				"font-weight");
	}

	/*
	 * Locator for List Criteria.
	 */
	private By listCriteria() {
		return By.xpath("//header[@id='listHead']/div[@id='listDesc']/p");
	}

	/*
	 * Function to check the presence of List Criteria under title.
	 */
	public boolean isListCriteriaPresent() {
		return isElementPresent(listCriteria());
	}

	/*
	 * Locator for List Description.
	 */
	private By listDescription(String desc) {
		if (desc.equalsIgnoreCase("short"))
			return By
					.xpath("//header[@id='listHead']/div[@id='listDesc']/div[@id='csstc__userDesc']");
		else
			return By
					.xpath("//header[@id='listHead']/div[@id='listDesc']/div[@id='csstc__userDesc']/div[@id='csstc__userDesc__inner']/div[@class='relative desc init grey']");
	}

	/*
	 * Function to check the presence of description below the list criteria.
	 */
	public boolean isListDescriptionPresent(String desc) {
		return isElementPresent(listDescription(desc));
	}

	/*
	 * Function to get the color of font in description.
	 */
	public String getColorOfListDescription(String desc) {
		return driver.findElement(listDescription(desc)).getCssValue("color");
	}

	/*
	 * Locator for more and less button.
	 */
	private By moreLess() {
		return By
				.xpath("//header[@id='listHead']/div[@id='listDesc']/div[@id='csstc__userDesc']/span[@id='csstc__userDesc__more']");
	}

	/*
	 * Function to make click on more button.
	 */
	public void clickOnMoreLess() {
		safeJavaScriptClick(moreLess(), VERYLONGWAIT);
	}

	/*
	 * Locator for various statics in stats bar in ultimate, reference and vote
	 * list.
	 */
	private By stats(String num) {
		return By
				.xpath("//header[@id='listHead']/div[@id='listData']/div[@class='midGrey serif data']/span["
						+ num + "]");
	}

	/*
	 * Function to check the presence of various statics in stats bar in
	 * ultimate, reference and vote list.
	 */
	public boolean isStatsPresent(int num) {
		return isElementPresent(stats(num + ""));
	}

	/*
	 * Function to get views in list
	 */

	public String getviewsinlist(int num) {
		return safeGetText(stats(num + ""), SHORTWAIT);
	}

	/*
	 * Function to check the font style of various statics in stats bar in
	 * ultimate, reference and vote list.
	 */
	public String getFontStyleOfStatsRerank(int num) {
		return driver.findElement(stats(num + "")).getCssValue("font-style");
	}

	/*
	 * Locator for title.
	 */
	private By title() {
		return By.xpath("//header[@id='listHead']/div[@id='listDesc']/h1/span");
	}

	/*
	 * Function to check the presence of title on any list page.
	 */
	public boolean isTitlePresent() {
		return isElementPresent(title());
	}

	/*
	 * Function to hover on title.
	 */
	public void hoverOverTitle() {
		mouseHoverJScript(title(), "Choice", MEDIUMWAIT);
		// mouseHover(title(), VERYLONGWAIT);
	}

	/*
	 * Function to get color of live ranking links on hovering.
	 */
	public String getColorOfTitleHover() {
		return driver.findElement(title()).getCssValue("color");
	}

	/*
	 * Function to click on title.
	 */
	public void clickOnTitle() {
		safeClick(title(), VERYLONGWAIT);
	}

	/*
	 * Function to get text of the title.
	 */
	public String getTextOfTitle() {
		return safeGetText(title(), VERYLONGWAIT);
	}

	/*
	 * Locator for OverLayTab.
	 */
	private By overLayTab(int number) {
		return By
				.xpath("//div[@id='listBody']/div[@class='relative visible']/div/ul/li["
						+ number + "]");
	}

	/*
	 * Function to click on title.
	 */
	public void clickOverLaytab(int number) {
		safeJavaScriptClick(overLayTab(number), VERYLONGWAIT);
	}

	/*
	 * Locator for options in overlay tab.
	 */
	private By optionInOverlayTab(int num) {
		return By
				.xpath("//div[@id='listBody']/div[@class='relative visible']/div/ul/li["
						+ num + "]/ul/li[" + num + "]");
	}

	/*
	 * Function to click on option in overlay tab.
	 */
	public void clickOnOptionInOverlayTab(int num) {
		safeClick(optionInOverlayTab(num), SHORTWAIT);
	}

	/*
	 * Function to check the color of see list ranked by text.
	 */
	public String getColorOfListRankedBy(int number) {
		return driver.findElement(overLayTab(number)).getCssValue("color");
	}

	/*
	 * Function to check whether the tabs in see list ranked by section
	 * clickable or not.
	 */
	public boolean isListRankedByTabsClickable(int number) {
		return isElementClickable(overLayTab(number), VERYLONGWAIT);
	}

	/*
	 * Function to check the presence of tabs in see list reranked by section.
	 */
	public boolean isListRerankedTabsPresent(int number) {
		return isElementPresent(overLayTab(number));
	}

	/*
	 * Locator for OverLayTab PopUp.
	 */
	private By IspresentOverLayTabPopUp() {
		return By
				.xpath("//div[@id='mlaTabs2_overlay']/div[@class='relative header demographics whiteBg visible']");
	}

	/*
	 * Function to check the presence of title on any list page.
	 */
	public boolean ispresentOverLaytabPopUp() {
		return isElementPresent(IspresentOverLayTabPopUp());
	}

	/*
	 * Locator for listimage.
	 */
	private By listimage(String num) {
		return By.xpath("//Section[@id='mainListCnt']/ol/li[" + num
				+ "]/div[@class='float relative img']/a//img");
	}

	/*
	 * Function to click on listimage.
	 */
	public void clicklistimage(int num) {
		safeJavaScriptClick(listimage(num + ""), VERYLONGWAIT);
	}

	/*
	 * Locator for listimage of get Href.
	 */
	private By getHreflistimage(String num) {
		return By.xpath("//Section[@id='mainListCnt']/ol/li[" + num
				+ "]/div[@class='float relative img']/a");
	}

	/*
	 * Function to get href of home link in breadCrumb in more info box.
	 */
	public String getHrefOflistimage(int num) {
		return driver.findElement(getHreflistimage(num + "")).getAttribute(
				"href");
	}

	/*
	 * Locator for adChoices
	 */
	private By adChoices(String number) {
		return By.xpath("//table/tbody/tr[1]/td[5]/table/tbody/tr[1]/td["
				+ number + "]/div/a");
	}

	/*
	 * Function to get href of the links in adChoices.
	 */
	public String gethrefOfadChoices(int number) {
		driver.switchTo()
				.frame(driver.findElement(By
						.xpath("//div[@id='siteBody']/article[@id='list']//div[@id='linkUnit']//ins[@class='adsbygoogle']//iframe[contains(@id,'aswift')]")));
		driver.switchTo().frame(
				driver.findElement(By
						.xpath("//iframe[contains(@id,'google_ads_frame')]")));
		return driver.findElement(adChoices(number + "")).getAttribute("href");
	}

	/*
	 * Function to make click on link in adChoices.
	 */
	public void clickOnadChoices(int number) {
		safeClick(adChoices(number + ""), VERYLONGWAIT);
	}

	/*
	 * Locator for title.
	 */
	private By aftermorewikilist(String num) {
		return By
				.xpath("//div[@class='relative nodeTaggedLinks serif lowercase']/a["
						+ num + "]");
	}

	/*
	 * Function to check the font style of various statics in stats bar in
	 * ultimate, reference and vote list.
	 */
	public String getFontStyleaftermorewikilist(int num) {
		return driver.findElement(aftermorewikilist(num + "")).getCssValue(
				"font-style");
	}

	/*
	 * Function to get colour of ultimate list tag.
	 */
	public String getColorOfaftermorewikilist(int num) {
		return driver.findElement(aftermorewikilist(num + "")).getCssValue(
				"color");
	}

	/*
	 * Function to make click on link in adChoices.
	 */
	public void clickOnwikilist(int number) {
		safeClick(aftermorewikilist(number + ""), VERYLONGWAIT);
	}

	/*
	 * Function to get href of the links in adChoices.
	 */
	public String gethrefOfwikilist(int num) {
		return driver.findElement(aftermorewikilist(num + "")).getAttribute(
				"href");
	}

	/*
	 * // * locator of overlay tab in node listed //
	 */
	// private By overlayinnodebutton(){
	// return By.xpath("//div[@class='relative name']/p/em[1]");
	// }
	// /*
	// * Function to make click on overlayin nodebutton(mostlistd)
	// */
	// public void clickonoverlayinnodebutton(){
	// safeClick(overlayinnodebutton(), VERYLONGWAIT);
	// }
	// /*
	// * locator of overlay nodebuttoninok
	// */
	// private By overlayinnodebuttoninok(){
	// return
	// By.xpath("//div[@id='listBadgeSticky_Most_Listed']//p/span[@class='inlineBlock btnDBlue']");
	// }
	// /*
	// * Function to make click on overlayinnodebuttoninok.
	// */
	// public void clickonoverlayinnodebuttoninok(){
	// safeJavaScriptClick(overlayinnodebuttoninok(), MEDIUMWAIT);
	// }
	// /*
	// * locator of overlay tab in overlayinvotebutton
	// */
	// private By overlayinvotebutton(){
	// return
	// By.xpath("//div[@class='float vote cunlock_hide_also ']/div[@class='float relative']//span");
	// }
	// /*
	// * Function to make click on overlayinvotebutton.
	// */
	// public void clickonoverlayinvotebutton(){
	// safeJavaScriptClick(overlayinvotebutton(), MEDIUMWAIT);
	// }

	/*
	 * Locator for combo box in rerank tab.
	 */
	private By rerankComboBox() {
		return By
				.xpath("//div[@id='mlaTabs2_overlay']/div[contains(@class,'relative header')]/div[@class='float relative select']/select");
	}

	/*
	 * Function to make click on combo box in rerank tab.
	 */
	public void clickOnRerankComboBox() {
		safeClick(rerankComboBox(), MEDIUMWAIT);
		// driver.findElement(rerankComboBox()).click();
	}

	/*
	 * Locator for combo box list in rerank tab.
	 */
	private By rerankComboBoxOptions(int num) {
		return By
				.xpath("//div[@id='mlaTabs2_overlay']/div[contains(@class,'relative header')]/div[@class='float relative select']/select/option[@value='"
						+ num + "']");
	}

	/*
	 * Function to make click on list of combo box in rerank tab.
	 */
	public void clickAndSelectOnRerankComboBox(int num) {
		safeClick(rerankComboBoxOptions(num), MEDIUMWAIT);
	}

	/*
	 * Function to check the presence of list of combo box in rerank tab.
	 */
	public boolean isRerankComboBoxOptionsPresent(int num) {
		scrollIntoViewThroughJavaScriptExecuter(rerankComboBoxOptions(num));
		return isElementPresent(rerankComboBoxOptions(num));
	}

	/*
	 * Locator for rerank combo box's nodes appearing for every user.
	 */
	private By rerankComboBoxNodes(int num) {
		return By.xpath("//div[@id='mlaTabs2_overlay']/ul[1]/li[" + num + "]");
	}

	/*
	 * Function to get text of rerank combo box's nodes appearing for every user
	 */
	public String getTextOfRerankComboBoxNodes(int num) {
		return safeGetText(rerankComboBoxNodes(num), MEDIUMWAIT);
	}

	/*
	 * Locator for node image in overlay.
	 */
	private By nodeImageInOverlay(int num) {

		return By
				.xpath("//div[@id='mlaHeadCont']/div[@class='floatRight absolute hidden whiteBg']/ul/li["
						+ num + "]/span/img");
	}

	/*
	 * Function to get the attribute of first image in the overlay.
	 */
	public String getSrcOfNodeImageInOverlay(int num) {
		return driver.findElement(nodeImageInOverlay(num)).getAttribute("src");
	}

	/*
	 * Locator for node name in overlay.
	 */
	private By nodeInOverlay(int num, String txt) {
		if (txt.equalsIgnoreCase("name"))
			txt = "//div[@id='mlaHeadCont']/div[@class='floatRight absolute hidden whiteBg']/ul/li["
					+ num + "]/div/p";
		else
			// height
			txt = "//div[@id='mlaHeadCont']/div[@class='floatRight absolute hidden whiteBg']/ul/li["
					+ num + "]";
		return By.xpath(txt);
	}

	/*
	 * Function to get text of node in overlay.
	 */
	public String getTextOfNodeInOverlay(int num, String txt) {
		return safeGetText(nodeInOverlay(num, txt), SHORTWAIT);
	}

	/*
	 * Function to get font-family of the node name in list.
	 */
	public String getFontOfNodeInOverlay(int num, String txt) {
		return driver.findElement(nodeInOverlay(num, txt)).getCssValue(
				"font-family");
	}

	/*
	 * Function to get height of node in overlay.
	 */
	public String getHeightOfNodeInOverlay(int num, String txt) {
		return driver.findElement(nodeInOverlay(num, txt))
				.getCssValue("height");
	}

	/*
	 * Function to check the presence of 50 nodes in overlay.
	 */
	public boolean isNodesInOverlayPresent(int num, String txt) {
		return isElementPresent(nodeInOverlay(num, txt));
	}

	/*
	 * Locator for node in list.
	 */
	private By nodeInList(String name) {
		if (name.equalsIgnoreCase("name"))
			name = "//section[@id='mainListCnt']/ol/li/div[@class='relative name']/p/a/span";
		else if (name.equalsIgnoreCase("image")) // image in list
			name = "//section[@id='mainListCnt']/ol/li/div[@class='float relative img']/a/img";
		else
			// height
			name = "//section[@id='mainListCnt']/ol/li";
		return By.xpath(name);

	}

	/*
	 * Function to get text of node name in list.
	 */
	public String getTextOfNodeInList(String name) {
		return safeGetText(nodeInList(name), SHORTWAIT);
	}

	/*
	 * Function to get attribute of node image in list.
	 */
	public String getSrcOfNodeImageInList(String src) {
		return driver.findElement(nodeInList(src)).getAttribute("src");
	}

	/*
	 * Function to get font-family of the node name in list.
	 */
	public String getFontOfNodeInList(String font) {
		return driver.findElement(nodeInList(font)).getCssValue("font-family");
	}

	/*
	 * Function to get height of node in list
	 */
	public String getHeightOfNodeInList(String height) {
		return driver.findElement(nodeInList(height)).getCssValue("height");
	}

	/*
	 * Function to check the presence of ultimate list in tag.
	 */
	public boolean isListTagsPresent() {
		return isElementPresent(moreInfoLink(), MEDIUMWAIT);
	}

	/*
	 * Locator for views.
	 */
	private By views() {
		return By
				.xpath("//div[@id='listData']/div[@class='midGrey serif data']/span[@class='inlineBlock item']");
	}

	/*
	 * Function to check the presence of ultimate list in tag.
	 */
	public boolean isListViewsPresent() {
		return isElementPresent(views(), MEDIUMWAIT);
	}

	/*
	 * Locator for facebook of list on footer.
	 */
	private By facebook() {
		// return By.id("share_facebook-share_shareFloaties");
		return By
				.xpath("//div[@id='shareFloater']/span[@id='share_facebook-share_shareFloaties']/span/i");
	}

	/*
	 * Function to make click on link in adChoices.
	 */
	public void clickOnfacebook() {
		safeJavaScriptClick(facebook(), VERYLONGWAIT);
	}

	/*
	 * Locator for facebook of list on footer.
	 */
	private By facebookwindowpresent() {
		return By.id("booklet");
	}
	/*
	 * Locator for facebook of list on footer.
	 */
	private By facebookAfterlogin() {
		return By.xpath("//a[contains(@href,'http://www.ranker.com/list/actors-nobody-cares-about-anymore/ranker-celebrities?')]");
	}
	/*
	 * Function to check the presence of facebook window after login
	 */
	public boolean isPresentfacebookAfterlogin() {
		return isElementPresent(facebookAfterlogin(), MEDIUMWAIT);
		
	}
	/*
	 * Function to hover on title.
	 */
	public void hoverOverfacebookAfterlogin() {
		mouseHover(facebookAfterlogin(), MEDIUMWAIT);
		// mouseHover(title(), VERYLONGWAIT);
	}
	/*
	 * Function to check the presence of facebook window after login
	 */
	public boolean isPresentfacebookwindowpresent() {
		return isElementPresent(facebookwindowpresent(), MEDIUMWAIT);
		
	}

	/*
	 * Locator for facebook of list on footer.
	 */
	private By facebookError() {
		return By.xpath("//div[@class='pam uiBoxRed']");
	}

	/*
	 * Function to check the presence of facebook window after login
	 */
	public boolean isPresentfacebookErrorpresent() {
		return isElementPresent(facebookError(), SHORTWAIT);
	}

	/*
	 * Locator for facebook of list on footer.
	 */
	private By twitter() {
		// return By.id("share_facebook-share_shareFloaties");
		return By
				.xpath("//div[@id='shareFloater']/span[@id='share_twitter-share_shareFloaties']/span/i");
	}

	/*
	 * Function to make click on link in adChoices.
	 */
	public void clickOntwitter() {
		safeJavaScriptClick(twitter(), VERYLONGWAIT);
	}

	/*
	 * Locator for twitter of list on footer.
	 */
	private By twiterwindowpresent() {
		return By.id("bd");
	}

	/*
	 * Function to check the presence of facebook window after login
	 */
	public boolean isPresenttwitterwindowpresent() {
		return isElementPresent(twiterwindowpresent(), SHORTWAIT);
	}

	/*
	 * Locator for facebook of list on footer.
	 */
	private By pinterest() {
		// return By.id("share_facebook-share_shareFloaties");
		return By
				.xpath("//div[@id='shareFloater']/span[@id='share_pinterest_shareFloaties']/span/i");
	}

	/*
	 * Function to make click on link in adChoices.
	 */
	public void clickOnpinterest() {
		safeJavaScriptClick(pinterest(), VERYLONGWAIT);
	}

	/*
	 * Locator for twitter of list on footer.
	 */
	private By pinterestwindowpresent() {
		return By.id("bd");
	}

	/*
	 * Function to check the presence of facebook window after login
	 */
	public boolean isPresentpinterestwindowpresent() {
		return isElementPresent(pinterestwindowpresent(), MEDIUMWAIT);
	}

	/*
	 * Locator for vote button.
	 */
	private By votebtn(int num) {
		return By.xpath("//section[@id='mainListCnt']/ol/li["+ num+ "]/div[@class='float vote']/div[@class='float relative']//i");
		//section[@id='mainListCnt']/ol/li[1]/div[@class='float vote']/div[@class='float relative']//i
//		return By.xpath("//section[@id='mainListCnt']/ol/li["+ num+ "]/div[@class='float vote cunlock_hide_also ']/div[@class='float relative']//i");
	}

	/*
	 * Function to click on vote button..
	 */
	public void clickonvotebtn(int num) {
		safeJavaScriptClick(votebtn(num), SHORTWAIT);
	}

	/*
	 * Locator for present mini edit sidebar
	 */
	private By minieditpresent() {
		return By.id("voteCounter2Data");
	}

	/*
	 * Function to check the presence of present mini edit sidebar
	 */
	public boolean isPresentminiedit() {
		return isElementPresent(minieditpresent(), MEDIUMWAIT);
	}

	/*
	 * Locator for flotter social chicklets at bottom.
	 */
	private By floterSocialChicklets(int num) {
		return By.xpath("//div[@id='shareFloater']/span[" + num + "]//i");
	}

	/*
	 * Function to click on flotter social chicklets at
	 * bottom.(FB,Twitter,Pinterest,Mail)
	 */
	public void clickOnFloterSocialChicklets(int num) {
		safeJavaScriptClick(floterSocialChicklets(num), MEDIUMWAIT);
	}

	/*
	 * Locator for link present in next section of Viewer Of This List Also Saw.
	 */
	private By nextListLinkBelowViewerOfThisListAlsoSaw(int num) {
		return By
				.xpath("//section[@id='listRelated']/ul[@class='noImg block']/li["
						+ num + "]/a");
	}

	/*
	 * Function to get href of link present in next section of Viewer Of This
	 * List Also Saw.
	 */
	public String gethrefOfNextListLinkBelowViewerOfThisListAlsoSaw(int num) {
		return driver
				.findElement(nextListLinkBelowViewerOfThisListAlsoSaw(num))
				.getAttribute("href");
	}

	/*
	 * Function to click link present in next section of Viewer Of This List
	 * Also Saw.
	 */
	public void clickNextListLinkBelowViewerOfThisListAlsoSaw(int num) {
		safeJavaScriptClick(nextListLinkBelowViewerOfThisListAlsoSaw(num),
				SHORTWAIT);
	}

	/*
	 * Locator for the node.
	 */
	private By node(String nodeNumber) {
		return By.xpath("//section[@id='mainListCnt']/ol[@class='mainList relative']/li["+ nodeNumber + "]");
	}

	/*
	 * This function is used to check presence of node.
	 */
	public void scrollToElement(String nodeNumber) {
		scrollIntoViewThroughJavaScriptExecuter(node(nodeNumber));
	}

	/*
	 * This function is used to check presence of node.
	 */
	public boolean isNodePresent(String nodeNumber) {
		return isElementPresent(node(nodeNumber), VERYLONGWAIT);
	}

	/*
	 * Locator for link present in Viewer Of This List Also Saw.
	 */
	private By viewerOfThisListAlsoSaw(int num) {
		return By.xpath("//section[@id='listRelated']/ul[@class='related']/li["
				+ num + "]/a");
	}

	/*
	 * Function to get href of link present in Viewer Of This List Also Saw.
	 */
	public String gethrefOfViewerOfThisListAlsoSaw(int num) {
		return driver.findElement(viewerOfThisListAlsoSaw(num)).getAttribute(
				"href");
	}

	/*
	 * Function to click link present in Viewer Of This List Also Saw.
	 */
	public void clickViewerOfThisListAlsoSaw(int num) {
		safeJavaScriptClick(viewerOfThisListAlsoSaw(num), SHORTWAIT);
	}

	/*
	 * Locator for link present in Viewer Of This List Also Saw.
	 */
	private By viewerOfThisListAlsoSawList() {
		return By.xpath("//section[@id='listRelated']/ul[@class='related']/li");
	}

	/*
	 * Function to get href of link present in Viewer Of This List Also Saw.
	 */
	public int getNumberOfLinksInViewerOfThisListAlsoSawSection() {
		return driver.findElements(viewerOfThisListAlsoSawList()).size();
	}

	/*
	 * Locator for link present in Viewer Of This List Also Saw.
	 */
	private By topQueriesBlock(int num) {
		return By.xpath("//footer[@id='buzzing']/ul/li[" + num + "]/a");
	}

	/*
	 * Function to get href of link present in Viewer Of This List Also Saw.
	 */
	public String gethrefOfTopQueriesBlock(int num) {
		return driver.findElement(topQueriesBlock(num)).getAttribute("href");
	}

	/*
	 * Function to click link present in Viewer Of This List Also Saw.
	 */
	public void clickTopQueriesBlock(int num) {
		safeJavaScriptClick(topQueriesBlock(num), SHORTWAIT);
	}

	/*
	 * Locator for present Viewer Of This List Also Saw.
	 */
	private By viewersBlock() {
		return By
				.xpath("//section[@id='listRelated']/header[@class='sectionHeaderBG']");
	}

	/*
	 * This function is used to check presence of viewers block.
	 */
	public boolean isviewersBlockPresent() {
		return isElementPresent(viewersBlock(), VERYLONGWAIT);
	}

	/*
	 * Locator for present popular Of This List Also Saw.
	 */
	private By popularBlock() {
		return By
				.xpath("//div[@class='relatedListsBlock']/h3[@class='blockHeaderBg blockHeaderFont grey']");
	}

	/*
	 * This function is used to check presence of node.
	 */
	public boolean ispopularsBlockPresent() {
		return isElementPresent(popularBlock(), VERYLONGWAIT);
	}

	/*
	 * Locator for link present in Viewer Of This List Also Saw.
	 */
	private By popularOfThisListblock(int num) {
		return By
				.xpath("//div[@class='relatedListsBlock']/ul[@class='related']/li["
						+ num + "]/div[@class='inlineBlock listLink black']/a");
	}

	/*
	 * Function to get href of link present in Viewer Of This List Also Saw.
	 */
	public String gethrefOfpopularOfThisListblock(int num) {
		return driver.findElement(popularOfThisListblock(num)).getAttribute(
				"href");
	}

	/*
	 * Function to click link present in Viewer Of This List Also Saw.
	 */
	public void clickonpopularOfThisListblock(int num) {
		safeJavaScriptClick(popularOfThisListblock(num), SHORTWAIT);
	}

	/*
	 * Locator for present popular Of This List Also Saw.
	 */
	private By propertyBlockinblog() {
		return By.xpath("//div[@class='rightMore block relative']");
	}

	/*
	 * This function is used to check presence of node.
	 */
	public boolean ispropertyBlockinblogPresent() {
		return isElementPresent(propertyBlockinblog(), VERYLONGWAIT);
	}

	/*
	 * Locator for present popular Of This List Also Saw.
	 */
	private By propertyBlockinslideshow() {
		return By.xpath("//div[@class='blogText clear']");
	}

	/*
	 * This function is used to check presence of node.
	 */
	public boolean ispropertyBlockinslideshowPresent() {
		scrollIntoViewThroughJavaScriptExecuter(propertyBlockinslideshow());
		return isElementPresent(propertyBlockinslideshow(), VERYLONGWAIT);
	}

	/*
	 * Locator for vote button.
	 */
	private By voteicon(int num) {
		return By
				.xpath("//section[@id='mainListCnt']/ol/li["+ num	+ "]/div[@class='float vote']/div[@class='float relative']/span");
	}

	/*
	 * Function to get attribute of vote icon
	 */
	public String getAttriOfvoteicon(int num) {
		return driver.findElement(voteicon(num)).getAttribute("class");
	}

	/*
	 * Locator for vote button.
	 */
	private By downvoteicon(int num) {
		return By
				.xpath("//section[@id='mainListCnt']/ol/li["
						+ num
						+ "]/div[@class='float vote cunlock_hide_also ']/div[@class='float relative'][2]/span");
	}

	/*
	 * Function to get attribute of vote icon
	 */
	public String getAttriOfdownvoteiconicon(int num) {
		return driver.findElement(downvoteicon(num)).getAttribute("class");
	}

	/*
	 * Locator for check box in monetizable tag
	 */
	private By tagsCheckBoxformonetizable() {

		return By.xpath("//input[@data-name='monetizable']");
	}

	/*
	 * Function to select check box of tag 'no monetizable'.
	 */
	public void selectTagsCheckBoxmonetizable() {
		safeJavaScriptClick(tagsCheckBoxformonetizable(), MEDIUMWAIT);
	}

	/*
	 * Locator for pagination
	 */
	private By pagination() {

		return By.id("paging");
	}

	/*
	 * This function is used to check presence of node.
	 */
	public boolean ispaginationPresent() {
		scrollIntoViewThroughJavaScriptExecuter(pagination());
		return isElementPresent(pagination(), SHORTWAIT);
	}

	/*
	 * This function is used to get background color of pagination
	 */
	public String getpaginationbackgrndColor() {
		return driver.findElement(pagination()).getCssValue("background-color");
	}

	/*
	 * Locator for check box in HTML Referral tag
	 */
	private By tagsCheckBoxforHTMLReferral() {
		// System.out.println("1111 com in this");
		return By.xpath("//input[@data-name='HTML Referral']");
	}

	/*
	 * Function to select check box of tag 'HTML Referral'.
	 */
	public void selectTagsCheckBoxHTMLReferral() {

		safeJavaScriptClick(tagsCheckBoxforHTMLReferral(), MEDIUMWAIT);
	}

	/*
	 * Locator for embed tab
	 */
	private By embedtab() {

		return By.id("mlaTab_embed");
	}

	/*
	 * This function is used to check presence of node.
	 */
	public boolean isembedtabPresent() {
		// scrollIntoViewThroughJavaScriptExecuter(pagination());
		return isElementPresent(embedtab(), SHORTWAIT);
	}

	/*
	 * Locator for embed tab
	 */
	private By tagscategory() {

		return By
				.xpath("//div[@id='listDataMore']/span[@id='breadCrumb']/a[@title='People']");
	}

	/*
	 * Function to get the text of tag.
	 */
	public String getTextOftagscategory() {
		return safeGetText(tagscategory(), SHORTWAIT);
	}

	/*
	 * Locator for next tab
	 */
	private By nextlistfooter() {
		return By.xpath("//div[@id='listFooter']/span[@id='nextListFooter']");
		// return By.id("nextListFooter");
	}

	/*
	 * Function to click on nextlistfooter..
	 */
	public void clickonnextlistfooter() {
		safeJavaScriptClick(nextlistfooter(), SHORTWAIT);
	}

	/*
	 * Function to get href of next list footer
	 */
	public String gethrefOfnextlistfooter() {
		return driver.findElement(nextlistfooter()).getAttribute("data-href");
	}

	/*
	 * Function to get href of next list footer
	 */
	public String gethrefOfnextlistfooterlist(String txt) {
		return driver.findElement(nextlistfooter()).getAttribute("data-href");
	}

	/*
	 * Locator for rerankstab
	 */
	private By rerankstab() {

		return By.id("mlaTab2_reranks");
	}
	/*
	 * Locator for rerankstab
	 */
	private By reranktab() {

		return By.xpath("//div[@id='mlaTabs2']/ul/li[@id='mlaTab2_reranks']/span");
	}
	/*
	 * Function to click on rerankstab
	 */
	public void clickonrerankstab() {
		safeJavaScriptClick(rerankstab(), SHORTWAIT);
	}

	private By rerankOverlayNode() {
		return By
				.xpath("//ul/li[@class='float relative block width100']/div[@class='relative block name black']/p[1]");
	}

	public String getTextOfrerankOverlayNode() {
		return safeGetText(rerankOverlayNode(), MEDIUMWAIT);
	}
	public String getTextOfreranktab() {
		return safeGetText(reranktab(), MEDIUMWAIT);
	}
	private By dropDownlist() {
		return By.xpath("//div[@class='float relative select']/select[@class='custom']/option[contains(text(),'Central')]");
	}

	public void clickOndropDownlist() {
		safeClick(dropDownlist(), MEDIUMWAIT);
	}

	private By selectdropdownOption() {
		return By
				.xpath("//div[@id='mlaTabs2_overlay']/div[@class='relative header demographics whiteBg visible']/div[@class='float relative select']/select[@class='custom']/option[contains(text(),'Central')]");
	}

	public void clickOnselectdropdownOption() {
		safeClick(selectdropdownOption(), MEDIUMWAIT);
	}

	/*
	 * Locator for addnoads
	 */
	private By addnoads() {
		//return By.xpath("//div[@id='UE_settings_tags']/ul[@id='UE_settings_tags_admin']/li[28]/span/input[contains(@data-name,'ad_noads')]");
		return By.xpath("//input[contains(@data-name,'ad_noads')]");
	}

	/*
	 * Function to make click on addnoads.
	 */
	public void clickOnaddnoads() {
		safeJavaScriptClick(addnoads(), VERYLONGWAIT);
	}

	/*
	 * This function is used to check presence of next list footer
	 */
	public boolean isnextlistfooterPresent() {
		return isElementPresent(nextlistfooter(), SHORTWAIT);
	}

	/*
	 * Locator for Expand icon
	 */
	private By Expandicon() {
		return By
				.xpath("//Section[@id='mainListCnt']/ol/li[last()]/span[@class='expander expand open floatRight absolute block pointer']/i");
	}

	/*
	 * Function to make click on addnoads.
	 */
	public void clickOnExpandiconInlist(int num) {
		safeJavaScriptClick(ExpandiconInlist(num), VERYLONGWAIT);
	}

	/*
	 * Locator for Expand icon
	 */
	private By ExpandiconInlist(int num) {
		return By.xpath("//Section[@id='mainListCnt']/ol/li["+ num+ "]/span[@class='expander expand open floatRight absolute block pointer']/i");
	}

	/*
	 * This function is used to check presence of Expand icon
	 */
	public boolean isExpandiconPresent() {
		return isElementPresent(Expandicon(), SHORTWAIT);
	}

	/*
	 * This function is used to check presence of Expand icon in list
	 */
	public boolean isExpandiconPresentInlist(int num) {
		return isElementPresent(ExpandiconInlist(num), SHORTWAIT);
	}

	/*
	 * Locator for Stickey
	 */
	private By StickeyInlist() {
		return By.id("shareChickletSticky");
	}

	/*
	 * This function is used to check presence of Stickey
	 */
	public boolean isStickeyInlistPresent() {
		return isElementPresent(StickeyInlist(), SHORTWAIT);
	}

	/*
	 * Locator for chicklets
	 */
	private By chicklets() {
		return By.xpath("//Section[@id='mainListCnt']/ol/li[last()]/div[contains(@class,'relative name')]/p/span[@class='shareBox inlineBlock rowShare']");
	}

	/*
	 * This function is used to check presence of chicklets
	 */
	public boolean ischickletsPresent() {
		scrollIntoViewThroughJavaScriptExecuter(chicklets());
		return isElementPresent(chicklets(), SHORTWAIT);
	}

	/*
	 * Locator for user name
	 */
	private By username() {
		return By
				.xpath("//div[@id='listData']/div[@class='midGrey serif data']/span[1]");
	}

	/*
	 * This function is used to check presence of next list footer
	 */
	public boolean isusernamePresent() {
		return isElementPresent(username(), SHORTWAIT);
	}

	/*
	 * Locator for InputListBox
	 */
	private By InputListBox() {
		return By
				.xpath("//div[@id='adminBar']/ul/li[11]/input[@id='adminSearchListId']");
		// return By.id("adminSearchListId");
	}

	/*
	 * This function is used to check presence of InputListBox
	 */
	public boolean isInputListBoxPresent() {
		return isElementPresent(InputListBox(), SHORTWAIT);
	}

	/*
	 * Function to make click on InputListBox
	 */
	public void clickOnInputListBox() {
		safeClick(InputListBox(), VERYLONGWAIT);
	}

	/*
	 * Function to get color of InputListBox.
	 */
	public String getColorOfInputListBox() {
		return driver.findElement(InputListBox()).getCssValue("color");
	}

	/*
	 * Locator for RLSubstats
	 */
	private By RLSubstats() {
		return By
				.xpath("//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front rlStatsWin']");
	}

	/*
	 * This function is used to check presence of RLSubstats
	 */
	public boolean isRLSubstatsPresent() {
		return isElementPresent(RLSubstats(), SHORTWAIT);
	}

	/*
	 * Locator for ROISubstats
	 */
	private By ROISubstats() {
		return By
				.xpath("//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front roiStatsWin']");
	}

	/*
	 * This function is used to check presence of ROISubstats
	 */
	public boolean isROISubstatsPresent() {
		return isElementPresent(ROISubstats(), SHORTWAIT);
	}

	/*
	 * Locator for Expand icon text
	 */
	private By ExpandiconText() {
		return By
				.xpath("//div[@class='relative width100 expander expander']/em[@class='relative block serif grey wikiText']");
	}

	/*
	 * This function is used to check presence of RLSubstats
	 */
	public boolean isExpandiconTextPresent() {
		return isElementPresent(ExpandiconText(), SHORTWAIT);
	}

	/*
	 * Locator for BlatherSource
	 */
	private By BlatherSource() {
		return By.xpath("//div[@class='blogText serif clear']/a");
	}
	/*
	 * Function to make click on BlatherSource
	 */
	public void clickOnBlatherSource() {
		safeClick(BlatherSource(), VERYLONGWAIT);
	}

	/*
	 * Function to get href of BlatherSource
	 */
	public String gethrefOfBlatherSource() {
		return driver.findElement(BlatherSource()).getAttribute("href");
	}

	/*
	 * Locator for showWiki
	 */
	private By showWiki() {
		return By.id("wikiToggle");
	}

	/*
	 * Function to make click on BlatherSource
	 */
	public void clickOnshowWiki() {
		safeJavaScriptClick(showWiki(), VERYLONGWAIT);
	}

	/*
	 * Locator for Firstnodetext
	 */
	private By Firstnodetext() {
		return By.xpath("//div[@class='relative name anClip']/p/em[@class='block black serif blather true']");
	}

	/*
	 * This function is used to check presence of Firstnodetext
	 */
	public boolean isFirstnodetextPresent() {
		return isElementPresent(Firstnodetext(), SHORTWAIT);
	}

	/*
	 * Locator for social chicklets
	 */
	private By socialchicklets(int num) {
		return By
				.xpath("//div[contains(@class,'relative name')]/p/span[@class='shareBox inlineBlock rowShare']/span[@class='inlineBlock iconWrap pointer']["+ num + "]/span");
		// return
		// By.xpath("//Section[@id='mainListCnt']/ol/li[last()]/div[@class='relative name]/p/span[@class='shareBox inlineBlock rowShare']");
	}

	/*
	 * Function to make click on BlatherSource
	 */
	public void clickOnsocialchicklets(int num) {
		safeJavaScriptClick(socialchicklets(num), MEDIUMWAIT);
	}

	/*
	 * Locator for nextFooter
	 */
	private By nextFooter() {
		return By.id("pagingBot_next");
	}

	/*
	 * This function is used to check presence ofnextFooter
	 */
	public boolean isnextFooterPresent() {
		return isElementPresent(nextFooter(), SHORTWAIT);
	}

	/*
	 * Locator for View top keywords
	 */
	private By ViewTopkeywords() {
		return By.id("viewTopKeywords");
	}

	/*
	 * Function to make click on ViewTopkeywords
	 */
	public void clickOnViewTopkeywords() {
		safeJavaScriptClick(ViewTopkeywords(), VERYLONGWAIT);
	}

	/*
	 * Locator for source in top keywords
	 */
	private By Source() {
		return By.xpath("//table[@id='topKeywords']/thead/tr/th[contains(text(),'Source')]");
	}
	/*
	 * Locator for source in top keywords
	 */
	private By topKeywords(int num) {
		return By.xpath("//table[@id='topKeywords']/tbody/tr["+num+"]");
	}
	/*
	 * This function is used to check presence of source in top keywords
	 */
	public boolean isSourcePresent() {
		return isElementPresent(Source(), SHORTWAIT);
	}
	/*
	 * This function is used to check presence of source in top keywords
	 */
	public boolean isPresenttopKeywords(int num) {
		return isElementPresent(topKeywords(num), SHORTWAIT);
	}
	/*
	 * Locator for admin Bury/unbury list
	 */
	private By Burylist() {
		return By.id("adminBuryList");
	}

	/*
	 * Function to make click on Burylist
	 */
	public void clickOnBurylist() {
		safeJavaScriptClick(Burylist(), VERYLONGWAIT);
	}
	/*
	 * Locator for larger block
	 */
	private By largerblock() {
		return By.id("jumpLargeBlock");
	}
	/*
	 * Function to get colour of ultimate list tag.
	 */
	public String getWidthoflargerblock() {
		return driver.findElement(largerblock()).getCssValue("width");
	}
	/*
	 * Locator for small block
	 */
	private By smallblock(int num) {
		return By.xpath("//div[@class='column inlineBlock'][4]/article["+num+"]");
	}
	/*
	 * Function to get width of largerblock
	 */
	public String getWidthofsmallblock(int num) {
		return driver.findElement(smallblock(num)).getCssValue("width");
	}
	/*
	 * Locator for facebook  text after  share
	 */
	private By Facebookshare() {
		//contains(@id,'aswift')
		return By.xpath("//*[contains(@href,'http://www.ranker.com/list/actors-nobody-cares-about-anymore/ranker-celebrities?&source=fbshare&fb_ref=Default')]");
	}
	/*
	 * This function is used to check presence of source in top keywords
	 */
	public boolean isFacebooksharePresent() {
		return isElementPresent(Facebookshare(), SHORTWAIT);
	}
//	/*
//	 * Function to get href of facebook share of link
//	 */
//	public String getHrefOfFacebookshare(String text) {
//		System.out.println("111111111  com in");
//		return driver.findElement(Facebookshare(text) ).getAttribute("href");
//	}
	/*
	 * Function to make click on Facebook share link
	 */
	public void clickOnFacebookshare() {
		driver.findElement(By.xpath("//a[contains(@href,'http://www.ranker.com/list/actors-nobody-cares-about-anymore/ranker-celebrities?')]")).click(); 
	}
	/*
	 * Locator for upload image option
	 */
	private By uploadimage() {
		return By.id("imageUploadForm");
	}
	/*
	 * This function is used to check presence of upload image option
	 */
	public boolean isPresentuploadimage() {
		return isElementPresent(uploadimage(), SHORTWAIT);
	}
	/*
	 * Locator for List Description.
	 */
	private By MoreDescriptionText() {
			return By.xpath("//div[@class='relative desc init grey']/p[2]");
	}
	/*
	 * Function to get the text of more description text
	 */
	public String getTextOfMoreDescriptionText() {
		return safeGetText(MoreDescriptionText(), VERYLONGWAIT);
	}
	/*
	 * Locator for overy of click on rerank tab.
	 */
	private By dropDownrerankoverlay() {
		return By.xpath("//div[@class='float relative select']/select[@class='custom']/option[@value='0']");
	}
	/*
	 * Locator for overy of click on rerank tab.
	 */
	private By dropDownrerank() {
		return By.xpath("//div[@class='float relative select']/select[@class='custom']");
	}
	/*
	 * Function to make click on rerank tab.
	 */
	public void clickOndropDownrerank() {
		safeJavaScriptClick(dropDownrerank(), VERYLONGWAIT);
	}
	/*
	 * This function is used to check presence on login user for overy of click on rerank tab.
	 */
	public boolean isPresentuserrerankovery() {
		return isElementPresent(dropDownrerankoverlay(), SHORTWAIT);
	}
	/*
	 * Function to get the text of ultimate list tag.
	 */
	public String getTextOfdropDownrerankoverlay() {
		return safeGetText(dropDownrerankoverlay(), VERYLONGWAIT);
	}
}
