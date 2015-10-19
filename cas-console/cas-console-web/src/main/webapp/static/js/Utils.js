/**
 * Created by zhaoyong on 2014-6-23.
 * 公用js
 */
(function ($, window) {
    'use strict';

    /**
     * 工具类
     * @constructor
     */
    var Utils = function () {
        return {
            /**
             * 动态导入静态资源文件js/css
             * @param rId 资源id，主要是为了避免重复加载
             * @param res 资源文件
             * @param callback 回调函数
             */
            $import: function (rId, res, callback) {
                if (res && 'string' == typeof res) {
                    if (rId) {
                        if ($($('#' + rId), $('head')).length > 0) {
                            return;
                        }
                    }

                    //加载资源文件
                    var sType = res.substring(res.lastIndexOf('.') + 1);
                    // 支持js/css
                    if (sType && ('js' == sType || 'css' == sType)) {
                        var isScript = (sType == 'js');
                        var tag = isScript ? 'script' : 'link';

                        var head = document.getElementsByTagName('head')[0];
                        // 创建节点
                        var linkScript = document.createElement(tag);
                        linkScript.type = isScript ? 'text/javascript' : 'text/css';
                        linkScript.charset = 'UTF-8';
                        if (!isScript) {
                            linkScript.rel = 'stylesheet';
                        }
                        isScript ? linkScript.src = res : linkScript.href = res;
                        if (callback && 'function' == typeof callback) {
                            if (linkScript.addEventListener) {
                                linkScript.addEventListener('load', function () {
                                    callback.call();
                                }, false);
                            } else if (linkScript.attachEvent) {
                                linkScript.attachEvent('onreadystatechange', function () {
                                    var target = window.event.srcElement;
                                    if (target.readyState == 'complete') {
                                        callback.call();
                                    }
                                });
                            }
                        }
                        head.appendChild(linkScript);
                    }
                }
            },
            /**
             * 判断字符串是否是一个日期格式的字符串
             * @param dateString string
             */
            $isDateString: function (dateString) {
                if (!dateString || 'string' != typeof dateString) {
                    return false;
                }
            },
            /**
             * 将日期格式的字符串解析成Date
             * @param dateString string
             * @param format 格式化字符串
             */
            $dateParser: function (dateString, format) {
                //判断dateString
                if (!Utils.$isDateString(dateString)) {
                }
            },
            /**
             * 日期格式化
             * @param date Date
             * @param format 格式化字符串
             */
            $datetimeFormat: function (date, format, locale) {
                function displayLocaleValue(data, locale) {
                    var language = locale || Utils.$browserLanguage();
                    if (!language) {
                        language = 'en_US';  //默认
                    }
                    if (data) {
                        for (var key in data) {
                            if (data.hasOwnProperty(key) && key.toLowerCase().indexOf(language.toLowerCase()) != -1) {
                                return data[key];
                            }
                        }
                    }
                    return '';
                }

                if (date) {
                    if (!format) {
                        format = 'yyyy-MM-dd HH:mm:ss';
                    }
                    switch (typeof date) {
                        case 'string':
                            date = Utils.$dateParser(date, format);
                            break;
                        case 'number':
                            date = new Date(date);
                            break;
                    }
                    if (date && date instanceof Date) {
                        var dict = {
                            'yyyy': date.getFullYear(),
                            'M': date.getMonth() + 1,
                            'd': date.getDate(),
                            'H': date.getHours(),
                            'm': date.getMinutes(),
                            's': date.getSeconds(),
                            'MM': ('' + (date.getMonth() + 101)).substring(1),
                            'Mon': function (month, locale) {
                                return displayLocaleValue(Utils.$month['Mon'][month], locale);
                            }(date.getMonth(), locale),
                            'Month': function (month, locale) {
                                return displayLocaleValue(Utils.$month['Month'][month], locale);
                            }(date.getMonth(), locale),
                            'dd': ('' + (date.getDate() + 100)).substring(1),
                            'HH': ('' + (date.getHours() + 100)).substring(1),
                            'mm': ('' + (date.getMinutes() + 100)).substring(1),
                            'ss': ('' + (date.getSeconds() + 100)).substring(1),
                            'EE': function (day, locale) {
                                return displayLocaleValue(Utils.$weekday['EE'][day], locale);
                            }(date.getDay(), locale),
                            'EEE': function (day, locale) {
                                return displayLocaleValue(Utils.$weekday['EEE'][day], locale);
                            }(date.getDay(), locale)
                        };
                        return format.replace(/(yyyy|Mon(th)?|MM?|dd?|HH?|mm?|ss?|EEE?)/g, function () {
                            return dict[arguments[0]];
                        });
                    }
                }
            },
            $weekday: {
                'EE': {
                    0: {'zh-CN': '周日', 'en-US': 'Sun'},
                    1: {'zh-CN': '周一', 'en-US': 'Mon'},
                    2: {'zh-CN': '周二', 'en-US': 'Tue'},
                    3: {'zh-CN': '周三', 'en-US': 'Wed'},
                    4: {'zh-CN': '周四', 'en-US': 'Thu'},
                    5: {'zh-CN': '周五', 'en-US': 'Fri'},
                    6: {'zh-CN': '周六', 'en-US': 'Sat'}
                },
                'EEE': {
                    0: {'zh-CN': '星期日', 'en-US': 'Sunday'},
                    1: {'zh-CN': '星期一', 'en-US': 'Monday'},
                    2: {'zh-CN': '星期二', 'en-US': 'Tuesday'},
                    3: {'zh-CN': '星期三', 'en-US': 'Wednesday'},
                    4: {'zh-CN': '星期四', 'en-US': 'Thursday'},
                    5: {'zh-CN': '星期五', 'en-US': 'Friday'},
                    6: {'zh-CN': '星期六', 'en-US': 'Saturday'}
                }
            },
            $month: {
                'Mon': {
                    0: {'zh-CN': '一月', 'en-US': 'Jan'},
                    1: {'zh-CN': '二月', 'en-US': 'Feb'},
                    2: {'zh-CN': '三月', 'en-US': 'Mar'},
                    3: {'zh-CN': '四月', 'en-US': 'Apr'},
                    4: {'zh-CN': '五月', 'en-US': 'May'},
                    5: {'zh-CN': '六月', 'en-US': 'Jun'},
                    6: {'zh-CN': '七月', 'en-US': 'Jul'},
                    7: {'zh-CN': '八月', 'en-US': 'Aug'},
                    8: {'zh-CN': '九月', 'en-US': 'Sep'},
                    9: {'zh-CN': '十月', 'en-US': 'Oct'},
                    10: {'zh-CN': '十一月', 'en-US': 'Nov'},
                    11: {'zh-CN': '十二月', 'en-US': 'Dec'}
                },
                'Month': {
                    0: {'zh-CN': '一月', 'en-US': 'January'},
                    1: {'zh-CN': '二月', 'en-US': 'February'},
                    2: {'zh-CN': '三月', 'en-US': 'March'},
                    3: {'zh-CN': '四月', 'en-US': 'April'},
                    4: {'zh-CN': '五月', 'en-US': 'May'},
                    5: {'zh-CN': '六月', 'en-US': 'June'},
                    6: {'zh-CN': '七月', 'en-US': 'July'},
                    7: {'zh-CN': '八月', 'en-US': 'August'},
                    8: {'zh-CN': '九月', 'en-US': 'September'},
                    9: {'zh-CN': '十月', 'en-US': 'October'},
                    10: {'zh-CN': '十一月', 'en-US': 'November'},
                    11: {'zh-CN': '十二月', 'en-US': 'December'}
                }
            },
            /**
             * 获取浏览器语言
             */
            $browserLanguage: function () {
                if (navigator.userLanguage) {
                    return navigator.userLanguage.toLowerCase();
                } else if (navigator.language) {
                    return navigator.language.toLowerCase();
                }
                return '';
            },
            /**
             * 图片自适应
             * @param elem 元素
             * @param referElem 参照元素
             */
            $imgSelfAdaption: function (elem, referElem) {
                if (elem) {
                    if (!referElem) {
                        referElem = $(elem).parent;
                    }
                    if (referElem) {
                        var that = $(elem), refer = $(referElem);
                        var width = that.width(), height = that.height(), referWidth = refer.width() || 0, referHeight = refer.height() || 0;
                        if (referWidth && referHeight) {
                            if (width / height >= referWidth / referHeight) {
                                that.height(referHeight).width(width * (referHeight / height));
                            } else {
                                that.width(referWidth).height(height * (referWidth / width));
                            }
                        }
                    }
                }
            },
            /**
             * 获取文件后缀
             * @param filename
             * @returns
             */
            $getFileSuffix: function(filename){
            	var suffix = '';
            	if(filename && filename.indexOf('.') > 0){
            		suffix = filename.substring(filename.lastIndexOf('.'));
            	}
            	return suffix;
            },
            /**
             * 文件对象地址
             * @param file 页面文件
             */
            $objectURL: function(file) {
            	var url = null;
            	try
            	{
            		if (window.createObjectURL) { // basic
            			url = window.createObjectURL(file);
            		} else if (window.URL) { // mozilla(firefox)
            			url = window.URL.createObjectURL(file);
            		} else if (window.webkitURL) { // webkit or chrome
            			url = window.webkitURL.createObjectURL(file);
            		}
            	} catch(e){
            		console.log(e);
            	}
        		return url;
        	}
        };
    }();

    window.Utils = Utils;
})
(jQuery, window);