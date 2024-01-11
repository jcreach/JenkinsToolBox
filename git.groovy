#!/usr/bin/env groovy
package com.JenkinsToolBox

class GitToolbox {

  def getShortSha1ForBranch(String branch = 'main') {
    def commitFullSha1 = powershell script: "git rev-parse origin/${branch}", returnStdout: true
    echo "sha1 commit full length ${commitFullSha1}"
    def shortChangeset = powershell script: "git rev-parse --short ${commitFullSha1}", returnStdout: true
    echo "sha1 commit short length ${shortChangeset}"
    shortChangeset = "${shortChangeset}".replace("\r\n", "")
    return shortChangeset
  }

}
