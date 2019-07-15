# dailyPractice
echo "# offer" >> README.md
git init
然后通过git add把项目添加到仓库（或git add .把该目录下的所有文件添加到仓库，注意点是用空格隔开的） git status来查看你当前的状态。
git commit -m "first commit"
git remote add origin https://github.com/cheng-ger/offer.git
git push -u origin master

如果你勾选了Initialize this repository with a README（就是创建仓库的时候自动给你创建一个README文件），那么到了第九步你将本地仓库内容推送到远程仓库的时候就会报一个failed to push some refs to https://github.com/guyibang/TEST2.git的错。
这是由于你新创建的那个仓库里面的README文件不在本地仓库目录中，这时我们可以通过以下命令先将内容合并以下：

$ git pull --rebase origin master

git remote add origin https://github.com/cheng-ger/offer.git
git push -u origin master
