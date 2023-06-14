param(
    [Parameter(Position=0)]
    [string]$commitMessage = "Submit Solution"
)

$currentTime = Get-Date -Format "yyyy-MM-dd HH:mm:ss"
$commitMessageWithTime = "$commitMessage - $currentTime"

git add .
git commit -m $commitMessageWithTime
git --no-pager log -n 1
