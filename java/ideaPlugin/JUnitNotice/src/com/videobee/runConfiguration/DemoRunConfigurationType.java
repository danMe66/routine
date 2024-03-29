// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.videobee.runConfiguration;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.icons.AllIcons;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class DemoRunConfigurationType implements ConfigurationType {

  static final String ID = "DemoRunConfiguration";

  @NotNull
  @Override
  public String getDisplayName() {
    return "Demo";
  }

  @Override
  public String getConfigurationTypeDescription() {
    return "Demo run configuration type";
  }

  @Override
  public Icon getIcon() {
    return AllIcons.General.Information;
  }

  @NotNull
  @Override
  public String getId() {
    return ID;
  }

  @Override
  public ConfigurationFactory[] getConfigurationFactories() {
    return new ConfigurationFactory[]{new DemoConfigurationFactory(this)};
  }

}
