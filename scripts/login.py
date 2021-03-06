# -*- coding: utf-8 -*

import requests
import sys
import io
import time
import json
from selenium import webdriver
from selenium.webdriver import DesiredCapabilities


def login(mobile, yanzhengma):
    user_agent = (
        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.135 Safari/537.36")
    dcap = dict(DesiredCapabilities.PHANTOMJS)
    dcap["phantomjs.page.settings.userAgent"] = user_agent

    # browser = webdriver.PhantomJS('phantomjs-2.1.1-windows/phantomjs-2.1.1-windows/bin/phantomjs.exe')
    browser = webdriver.PhantomJS('/usr/local/bin/phantomjs')

    url = r'https://login.10086.cn/login.html?channelID=12034&backUrl=http%3A%2F%2Fwww.10086.cn%2Findex%2Fsc%2Findex_280_817.html%3FWT.mc_id%3Dj4cjLiavhrFcg0AFIYX5_RuifvL8JGtflKh3Cq3zd1619242836.742wm0x171d88o78t165xm0w'
    # 访问登录页面
    browser.get(url)
    browser.implicitly_wait(3)
    browser.find_element_by_xpath("/html/body/div[1]/div[1]/a[2]").click()
    browser.find_element_by_xpath("/html/body/div[1]/div/div/span/a").click()

    # browser.find_element_by_id("loginArea").click()
    # 等待一定时间，让js脚本加载完毕
    browser.implicitly_wait(3)
    browser.find_element_by_id("sms_login_1").click()
    # 输入用户名
    username = browser.find_element_by_id('sms_name')
    username.send_keys(mobile)
    # browser.find_element_by_id("getSMSPwd1").click()
    password = browser.find_element_by_id('sms_pwd_l')
    password.send_keys(yanzhengma)

    # 点击“登录”按钮17860550601
    login_button = browser.find_element_by_id("submit_bt")
    login_button.click()
    time.sleep(3)
    print(browser.page_source)
    browser.find_element_by_xpath("/html/body/div[2]/div[2]/ul/li[3]/a").click()
    browser.find_element_by_xpath("/html/body/div[2]/div[2]/ul/li[3]/a").click()
    time.sleep(3)
    browser.find_element_by_xpath("/html/body/div[2]/div[2]/ul/li[3]/a").click()
    cookie = [item["name"] + "=" + item["value"] for item in browser.get_cookies()]
    cookiestr = '; '.join(item for item in cookie)
    with open('coike.txt', 'w')as f:
        f.write(cookiestr)
    print(cookiestr)


if __name__ == '__main__':
    # mobile = input('输入手机号')
    # yanzhengma = input("输入验证码")
    tel = int(sys.argv[1])
    code = int(sys.argv[2])
    login(tel, code)
