# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.

# -*- codeing = utf-8 -*-
# @time : 2021/3/19 21:18
# @Author : WYJ
# @File : 测试函数2.py
# @Software : PyCharm

# import requests
# import time
import requests
import time
import os
import json
import requests
import sys
import io
import time
import json
from selenium import webdriver
from selenium.webdriver import DesiredCapabilities

with open('coike.txt') as file_obj:
    cookie = file_obj.read()
    # print(cookie)

# def get_cooike(tel):
#     user_agent = (
#         "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.135 Safari/537.36")
#     dcap = dict(DesiredCapabilities.PHANTOMJS)
#     dcap["phantomjs.page.settings.userAgent"] = user_agent
#     driver = webdriver.PhantomJS(executable_path=r"./phantomjs-2.1.1-windows/phantomjs-2.1.1-windows/bin/phantomjs.exe",
#                                  desired_capabilities=dcap)
#     # browser =webdriver.Chrome(r"C:\Users\Administrator\Downloads\chromedriver_win32 (4)\chromedriver.exe",chrome_options=options)
#     browser = webdriver.PhantomJS('phantomjs-2.1.1-windows/phantomjs-2.1.1-windows/bin/phantomjs.exe')
#
#     # 登录页面
#     url = r'https://login.10086.cn/login.html?channelID=12034&backUrl=http%3A%2F%2Fwww.10086.cn%2Findex%2Fsc%2Findex_280_817.html%3FWT.mc_id%3Dj4cjLiavhrFcg0AFIYX5_RuifvL8JGtflKh3Cq3zd1619242836.742wm0x171d88o78t165xm0w'
#     # 访问登录页面
#     browser.get(url)
#     browser.implicitly_wait(3)
#     browser.find_element_by_xpath("/html/body/div[1]/div[1]/a[2]").click()
#     browser.find_element_by_xpath("/html/body/div[1]/div/div/span/a").click()
#
#     # browser.find_element_by_id("loginArea").click()
#     # 等待一定时间，让js脚本加载完毕
#     browser.implicitly_wait(3)
#     browser.find_element_by_id("sms_login_1").click()
#     # 输入用户名
#     username = browser.find_element_by_id('sms_name')
#     username.send_keys(tel)
#
#     browser.find_element_by_id("getSMSPwd1").click()
#     # 输入密码
#     password = browser.find_element_by_id('sms_pwd_l')
#     yanzhengma = input("请输入验证码")
#     password.send_keys(yanzhengma)
#
#     # 点击“登录”按钮17860550601
#     login_button = browser.find_element_by_id("submit_bt")
#     login_button.click()
#
#     browser.find_element_by_xpath("/html/body/div[2]/div[2]/ul/li[3]/a").click()
#     browser.find_element_by_xpath("/html/body/div[2]/div[2]/ul/li[3]/a").click()
#     time.sleep(3)
#     browser.find_element_by_xpath("/html/body/div[2]/div[2]/ul/li[3]/a").click()
#     cookie = [item["name"] + "=" + item["value"] for item in browser.get_cookies()]
#     cookiestr = '; '.join(item for item in cookie)
#     with open('coike.txt', 'w')as f:
#         f.write(cookiestr)
#     print(cookiestr)
#     return cookiestr


# tel = int(input("请输入手机号"))
tel = int(sys.argv[1])
# cooike="WT_FPC=id=20cf0a7afb1ec02c6f51619267328968:lv=1619267357361:ss=1619267328968; iPCrGkRfd0XkT=53EAJvDclkSGqqqmyqeYq0GPBzHoQN.VrbY0z5OXn5t.LRgzlZT3LuCsyNQnnNbziGXSKkC1BGGTX_u5dh407bwenc5RZ1pF0KKsfBgMKZgnVe0xrFcBNrh51vdJRooPlceeORR60VArV1kHh5RUcbfoYYDONb0lV8tjKxn2atAXoFLeRgwfRxLEs8SJEf5HUdZCekQlSDrRTEYjFXzjBL31Nn6Wu3fTi0G_99bxR6E_mEYxM50X4_6KgUmDIbdNITL99_GTctjhWO3EMrbxbMxd_WtZ0TMMGmPG9oZIT_WJt3H2iFS6R1old.DbP90rN7; mobile=34128-22017-6025-34319; CmProvid=bj; CmLocation=531|531; collect_id=gh6tf7bm1bhsj2dr56j7ub2ke5k78s1j; jsessionid-cmcc=n016DE2FEA6940D2A85A020B10767D7DA-1; vtime=1619267352478; shopuid=72b18ebc-10db-46af-8c2c-77a3b6564512; c=56180e7a64d4410286742f7262330e41; is_login=true; cmccssotoken=56180e7a64d4410286742f7262330e41@.10086.cn; sendflag=20210424202858673903; lgToken=288d99d990f14cbf9762c0c0fbecc6ad; cart_code_key=ogvjo2ojr1c7s747785ec5d7i4; PHPSESSID=ogvjo2ojr1c7s747785ec5d7i4; iPCrGkRfd0XkS=5pKjKWEPAcbWSpY0IbnPXABesd.A_v_m7xDIjOzuQKUDcJKTYVnzfb8ueZBAGwNbRalxGTzgg0vWyzhsNAm1hHA"
# cookie='ssologinprovince=531; inx=myorders; inx2=returnorderqry; iPCrGkRfd0XkS=5AATeXz340d2F7HUzp6qV2e0kvPvvMPCBYlc5gRLFY6ty.ck2zR8QMwO1fjvKQT7E74BwYw4Sl8JnCnZvcxGDgq; collect_id=h5jdu34fmqbfejt8ja65etort8pib2pf; jsessionid-cmcc=n0FDBB4AB6D14EBE8D7F04BAF5B40C613-1; CaptchaCode=FoCHMi; lgToken=148a2efd2dfa4191b8115aafeb0ddc51; cmccssotoken=31a1a81faa7744d1a1a1084fdfaba1c1@.10086.cn; is_login=true; c=31a1a81faa7744d1a1a1084fdfaba1c1; key4IE89=5FB29E5A85C13D8A85F5170E18506578BE6C5F49EEC5563F5F7E49D75375E8D5CB5426178DC47FDEB67CD4D8FD723AA6; SSOCookie=""; PHPSESSID=bub5klj4n3oimq6h2l62hoerv6; shopuid=42820915-56b1-456b-b8f8-33346b6fe2d1; sendflag=20210424155907644168; vtime=1619251209352; iPCrGkRfd0XkT=53EHiObck0q9qqqmyqz5Geasjxv6T6bbnt8P6.wMUCVhElx1HDHreLUqIda6IChtsDnLJ._B_EwfMpBEveQxuxHonnmEd57.Gdk7CpKMbiexSrwaU.de0ZaZW3ByKpiNC4FkiV1PUsN_82NQcqTQS7UCNvNWapiMpce9I2Vt8WYkDLiOJvEnWxIBlGI0fMEfdgllmy6YYM87Z0Bjvr_QDNvcaK_vfSlBXCTVz3edh7WLqp6ycAfWI_k5IjHPa0Gk0qqqAzXnOipraHYNMTibBVFffPYiSxnQ2FJQeso_ITQTuUVY06lzbBetDHpab2y5ML; CmLocation=531|531; CmProvid=bj; WT_FPC=id=245cf389e5d85a9ae051619247445847:lv=1619251293316:ss=1619247445847; mobile=54608-9729-5986-34319'
# cookie = 'ssologinprovince=280; inx2=returnorderqry; inx=myorders; WT_FPCN=id=28d2f32536c31273dd91601106112720:lv=1601106183958:ss=1601106112720; iPCrGkRfd0XkS=5WcFMbTcTIejtfM6Rl3MjQSPQWhUuNZ4yebEC3II_o1Tg0zuGfk3IqCoTa1uJncRqjd5TRAeZyY1lgXzH4OamOq; CmLocation=280|817; shopuid=fa95dffa-476b-4289-843b-8d51577044de; webUid_webUid=70ff14c0-bbee-0b9f-8679-f4cc8d9802b9; footprint_key=54okrv294bb7qsrkg3pbrgika1; PHPSESSID=padubtfd0drpmq8b9a6jooclo2; cart_code_key=padubtfd0drpmq8b9a6jooclo2; collect_id=190b7035dvafoe8k6uv3h9d2gyqolrox; jsessionid-cmcc=n5988415D2747AE1361550B1B65F9E001-1; cmccssotoken=d665ce3edb6d43afb96d6c3bbbd8fea8@.10086.cn; mobile=5890-58721-6532-34841; vtime=1619178056462; enable_iPCrGkRfd0Xk=true; iPCrGkRfd0XkT=53EtSNDcc7MQqqqmgdLfkuG2ELeJw1PntuDgF7We_Nvn7k7iZ603XXtZOGrRFZp8Tw1xqe0.cctG_sMMoPXZIHa2IjfWV2SjQUOFpQNGxB7NBignQRPX9buSEArxAnNjmPR5SpFfd_QSgPtBt31LmWuLXVjeqZ52S.0DM0iH2iUStzc.ioIEdyDHeI_eFxU.fNiZJjDC2.LXmzPuMXWOTeMpd87oHhSrSR4ud4kEBhriYbsk2Wk4A7IGIty2LuEVdw4L1KzltZqhQqZvth.wQa2jWAG6IO819CmCTY9A8EvicBuFJGM7Qt4Y8nazHgylZQ; key4IE89=2228199F9D46CDE985B2B4E4D57603D23DF740191FCC6F3D0038AAC195CBFBCA11CCCFB9FE62CE01155CD3D27B35D335; sendflag=20210423194306117243; lgToken=42ca1c2efe3b4daeb39d89fc2a3bd697; CmProvid=bj; WT_FPC=id=2611e421ad56fc6e6d31611126415321:lv=1619178477415:ss=1619177698196'
# 时间戳-------------------------------------------时间戳
time1 = int(round(time.time(), 3) * 1000)
time1 = str(time1)
year = time.localtime().tm_year
year = str(year)
mon = time.localtime().tm_mon
if mon < 10:
    mon = '0' + str(mon)
else:
    mon = str(mon)
yearmon = year + mon
starttime = str(int(yearmon) - 2) + '01'
ymd = yearmon + str(time.localtime().tm_mday)
# --------------------------------------------------------


session = requests.session()
heaeders = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.70 Safari/537.36',
    # 'referer':'https://www.icourse163.org/channel/2002.htm'
    'cookie': cookie,
    # 'referer':'https://shop.10086.cn/i/?f=home&welcome=1618718071867'
}
# data = {
# 'mocCourseQueryVo':'{"categoryId":-1,"categoryChannelId":2002,"orderBy":0,"stats":30,"pageIndex":1,"pageSize":20}'
# }
# session = requests.session()
# session.get(url='https://www.icourse163.org/channel/2002.htm',headers=heaeders)
# print('time:%s'%time.time())

url = 'https://shop.10086.cn/i/v1/fee/touchbillinfo/%d?bgnMonth=%s&endMonth=%s&_=%s' % (tel, yearmon, yearmon, time1)
zhangdan = session.get(url=url, headers=heaeders).json()
url1 = 'https://shop.10086.cn/i/v1/fee/planbal/%d?_=%s' % (tel, time1)
yuliangchaxun = session.get(url=url1, headers=heaeders).json()
url2 = 'https://shop.10086.cn/i/v1/busi/order/%d?_=%s' % (tel, time1)
yewuchaxuntuiding = session.get(url=url2, headers=heaeders).json()
url3 = 'https://shop.10086.cn/i/v1/cust/his/%d?startTime=%s&endTime=%s&_=%s' % (tel, starttime, ymd, time1)
chongzhijilu = session.get(url=url3, headers=heaeders).json()
url4 = 'https://shop.10086.cn/i/v1/busi/plan/%d?_=%s' % (tel, time1)
url44 = 'https://shop.10086.cn/i/v1/cust/info/%d?_=%s' % (tel, time1)
gerenxinxi1 = session.get(url=url4, headers=heaeders).json()
gerenxinxi2 = session.get(url=url44, headers=heaeders).json()
url5 = 'https://shop.10086.cn/i/v1/fee/customertrend/%d?nowMonth=%s&_=%s' % (tel, yearmon, time1)
url6 = 'https://shop.10086.cn/i/v1/fee/planbal/%d?_=%s' % (tel, time1)
url7 = 'https://shop.10086.cn/i/v1/fee/real/%d?_=%s ' % (tel, time1)

# print(url5)
xiao_fei_qu_shi = session.get(url=url5, headers=heaeders).json()
xiao_fei = session.get(url=url6, headers=heaeders).json()
hua_fei_yu_liang = session.get(url=url7, headers=heaeders).json()

# print(zhangdan)  # 账单
# print(yuliangchaxun)  # 余量查询
# print(yewuchaxuntuiding)  # 业务查询
# print(chongzhijilu)  # 充值记录
# print(gerenxinxi1)  # 个人信息第一部分
# print(gerenxinxi2)  # 个人信息第二部分
# print(xiao_fei_qu_shi)  # 消费趋势
# print(xiao_fei)  # 消费
# print(hua_fei_yu_liang)  # 话费余量

print(json.dumps(zhangdan))  # 账单
print(json.dumps(yuliangchaxun))  # 余量查询
print(json.dumps(yewuchaxuntuiding))  # 业务查询
print(json.dumps(chongzhijilu))  # 充值记录
print(json.dumps(gerenxinxi1))  # 个人信息第一部分
print(json.dumps(gerenxinxi2))  # 个人信息第二部分
print(json.dumps(xiao_fei_qu_shi))  # 消费趋势
print(json.dumps(xiao_fei))  # 消费
print(json.dumps(hua_fei_yu_liang))  # 话费余量

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
