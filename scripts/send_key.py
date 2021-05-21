# -*- coding: utf-8 -*

import requests
import sys
import io
import time
import json
from selenium import webdriver
from selenium.webdriver import DesiredCapabilities


def send(mobile):
    user_agent = (
        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.135 Safari/537.36")
    dcap = dict(DesiredCapabilities.PHANTOMJS)
    dcap["phantomjs.page.settings.userAgent"] = user_agent
    # driver = webdriver.PhantomJS(executable_path=r"./phantomjs-2.1.1-windows/phantomjs-2.1.1-windows/bin/phantomjs.exe",
    #                              desired_capabilities=dcap)
    # browser =webdriver.Chrome(r"C:\Users\Administrator\Downloads\chromedriver_win32 (4)\chromedriver.exe",chrome_options=options)
    # browser = webdriver.PhantomJS('phantomjs-2.1.1-windows/phantomjs-2.1.1-windows/bin/phantomjs.exe')
    browser = webdriver.PhantomJS('/usr/local/bin/phantomjs')

    # 登录页面
    url = r'https://login.10086.cn/login.html?channelID=12034&backUrl=http%3A%2F%2Fwww.10086.cn%2Findex%2Fsc%2Findex_280_817.html%3FWT.mc_id%3Dj4cjLiavhrFcg0AFIYX5_RuifvL8JGtflKh3Cq3zd1619242836.742wm0x171d88o78t165xm0w'
    with open('url.txt', 'w')as f:
        f.write(url)
        print(url)
    # 访问登录页面
    browser.get(url)
    browser.implicitly_wait(3)
    browser.find_element_by_xpath("/html/body/div[1]/div[1]/a[2]").click()
    browser.find_element_by_xpath("/html/body/div[1]/div/div/span/a").click()
    # 17260333239
    # browser.find_element_by_id("loginArea").click()
    # 等待一定时间，让js脚本加载完毕
    browser.implicitly_wait(3)
    browser.find_element_by_id("sms_login_1").click()
    # 输入用户名
    username = browser.find_element_by_id('sms_name')
    # mobile = input("请输入手机号")
    username.send_keys(mobile)

    browser.find_element_by_id("getSMSPwd1").click()

    print("code success")

    with open("cookie", mode='w+') as file:
        cookies = browser.get_cookies()
        file.writelines(json.dumps(cookies))


if __name__ == '__main__':
    # mobile = input('输入手机号')
    mobile = int(sys.argv[1])
    print(mobile)
    send(mobile)
