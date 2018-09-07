package com.chrisrm.idea.themes.literature.club.dark

import com.chrisrm.idea.themes.literature.club.MTDokiDokiTheme

//todo: should probably rename these to something more expected :|
class EdgyTheme: MTDokiDokiTheme("yuri.dark", "Edgy", true, "Yuri") {

    override fun getBackgroundColorString(): String = "322A45"

    override fun getClubMember(): String = "yuri_dark.png"

    override fun joyfulClubMember(): String = "yuri.png"

    override fun getSecondaryBackgroundColorString(): String = "412D62"

    override fun getSecondaryForegroundColorString(): String = "9965BC"

    override fun getSelectionForegroundColorString(): String = "B39EFF"

    override fun getSelectionBackgroundColorString(): String = "442463"

    override fun getTreeSelectionBackgroundColorString(): String = "442463"

    override fun getMenuBarSelectionForegroundColorString(): String = "ffffff"

    override fun getMenuBarSelectionBackgroundColorString(): String = "56009D"

    override fun getNotificationsColorString(): String = "36274E"

    override fun getContrastColorString(): String = "473960"

    override fun getEditorTabColorString(): String = contrastColorString

    override fun getButtonBackgroundColor(): String = contrastColorString

    override fun getButtonForegroundColor(): String = "7469C7"

    override fun getForegroundColorString(): String = "917DEA"

    override fun getDisabled(): String = "17C704"

    override fun getTextColorString(): String = "916ACE"

    override fun getNonProjectFileScopeColor(): String = "272132"

    override fun getTestScope(): String = "0f2a00"

    override fun getSecondBorderColorString(): String = "50237C"
}