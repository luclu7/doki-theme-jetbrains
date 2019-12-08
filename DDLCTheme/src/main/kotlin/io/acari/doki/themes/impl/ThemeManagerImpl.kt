package io.acari.doki.themes.impl

import com.google.gson.Gson
import com.intellij.ide.ui.UITheme
import com.intellij.ide.ui.laf.LafManagerImpl
import com.intellij.ide.ui.laf.UIThemeBasedLookAndFeelInfo
import com.intellij.util.io.inputStream
import io.acari.doki.themes.DokiTheme
import io.acari.doki.themes.ThemeManager
import io.acari.doki.util.toOptional
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*
import java.util.stream.Collectors
import javax.swing.UIManager

class ThemeManagerImpl : ThemeManager {

  private val themeMap: Map<String, UITheme>

  init {
    val gson = Gson()
    val path = this.javaClass.classLoader.getResource("themes").path
    themeMap = Files.walk(Paths.get(path))
      .filter { it.endsWith(".theme.json") }
      .map { it.inputStream() }
      .map {
        gson.fromJson(
          InputStreamReader(it, StandardCharsets.UTF_8),
          UITheme::class.java
        )
      }
      .collect(
        Collectors.toMap(
          { it.name },
          { it },
          { a, _ -> a }
        ))

    println(themeMap)
  }

  override val currentTheme: Optional<DokiTheme>
    get() = processLaf(LafManagerImpl.getInstance().currentLookAndFeel)


  override fun processLaf(currentLaf: UIManager.LookAndFeelInfo?): Optional<DokiTheme> {
    return currentLaf.toOptional()
      .filter { it is UIThemeBasedLookAndFeelInfo }
      .map { it as UIThemeBasedLookAndFeelInfo }
      .filter { themeMap.containsKey(it.name) }
      .map { DokiTheme(it) }
  }
}