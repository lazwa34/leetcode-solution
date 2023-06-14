#!/bin/bash

commitMessage="${1:-Submit Solution}"
currentTime=$(date +"%Y-%m-%d %H:%M:%S")
commitMessageWithTime="$commitMessage - $currentTime"

git add .
git commit -m "$commitMessageWithTime"
git --no-pager log -n 1
