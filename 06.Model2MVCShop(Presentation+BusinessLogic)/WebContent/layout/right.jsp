<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
        * {
            padding: 0;
            margin: 0;
            box-sizing: border-box;
        }

        li {
            list-style: none;
        }

        a {
            text-decoration: none;
            color: inherit;
        }

        body {
            font-family: 'Roboto', sans-serif;
            font-family: 'Nanum Gothic', sans-serif;
            font-size: 16px;
            color: #898989;
        }
        div.wrap {
            margin: 0 auto;
            overflow: hidden;
            width: 1370px;
        }
        div.image-slide {
            position: relative;
            width: 940px;
            height: 476px;
            float: left;
        }

        div.image-slide>div.box {
            position: absolute;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: hidden;
        }

        div.image-slide ul.slide {
            position: absolute;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
        }

        div.image-slide ul.slide li {
            position: absolute;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            display: none;
        }

        div.image-slide ul.slide li:first-child {
            display: block;
        }

        div.image-slide ul.slide li>a {
            display: block;
        }

        div.image-slide ul.indicator {
            position: absolute;
            left: 0;
            bottom: 20px;
            width: 100%;
            text-align: center;
        }

        div.image-slide ul.indicator li {
            display: inline-block;
        }

        div.image-slide ul.indicator li+li {
            margin-left: 3px;
        }

        div.image-slide ul.indicator li a {
            display: block;
            width: 10px;
            height: 10px;
            background: #8C8C8C;
            border-radius: 20px;
            overflow: hidden;
            text-indent: -999px;
        }

        div.image-slide ul.indicator li.on a {
            background: #ffffff;
        }

        ul.slide li img {
            width: 100%;
        }
        
        div.event {
            width: 400px;
            float: left;
            margin-left: 30px;
        }
        div.event img {
            width: 100%;
        }
        div.article {
            height: 300px;
            font-size: 12px;
            color: #393939;
        }
        
        
    </style>
    <script src="/javascript/jquery-3.4.1.min.js"></script>
    <script>
        $(document).ready(function() {
            preventDefaultAnchor();
			
            




            function preventDefaultAnchor() {
                $(document).on('click', 'a[href="#"]', function(e) {
                    e.preventDefault();
                });
            }

            var numSlide = $('ul.slide li').length;
            var slideNow = 0;
            var slidePrev = 0;
            var slideNext = 0;
            var slideFirst = 1;
            var timerId = null;
            var isTimerOn = true;
            var timerSpeed = 3000;

            $('ul.slide li').each(function(i) {
                $(this).css({
                    'left': (i * 100) + '%',
                    'display': 'block'
                });
                $('ul.indicator').append('<li><a href="#">' + (i + 1) + '번 슬라이드</a></li>\n');
            });

            showSlide(slideFirst);

            $('ul.indicator li a').on('click', function() {
                var index = $('ul.indicator li').index($(this).parent());
                showSlide(index + 1);
            });

            function showSlide(n) {
                clearTimeout(timerId);
                if (slideNow === 0) {
                    $('ul.slide').css({
                        'transition': 'none',
                        'left': -((n - 1) * 100) + '%'
                    });
                } else {
                    $('ul.slide').css({
                        'transition': 'left 0.3s',
                        'left': -((n - 1) * 100) + '%'
                    });
                }

                $('ul.indicator li').removeClass('on');

                $('ul.indicator li:eq(' + (n - 1) + ')').addClass('on');

                slideNow = n;
                slidePrev = (n - 1) < 1 ? numSlide : n - 1;
                slideNext = (n + 1) > numSlide ? 1 : n + 1;

                if (isTimerOn === true) {
                    timerId = setTimeout(function() {
                        showSlide(slideNext);
                    }, timerSpeed);
                }
            }

        });
    </script>
</head>
<body>
<div class="wrap">
<div class="image-slide">
        <div class="box">
            <ul class="slide">
                <li><a href="#"><img src="/images/slideImage/84f4fd0ba83c0331bc65f9cd825c5b31.jpg" alt=""></a></li>
                <li><a href="#"><img src="/images/slideImage/3930834157187dfd4f516f65184f754a.jpg" alt=""></a></li>
                <li><a href="#"><img src="/images/slideImage/d3e6c3cd5d50d1d08173d16a6e469ae9.jpg" alt=""></a></li>
                <li><a href="#"><img src="/images/slideImage/dea24549e7715cb5c8006015a80fc327.jpg" alt=""></a></li>
                <li><a href="#"><img src="/images/slideImage/f8fbd51ba6322822eed1a36dc19d4d4d.jpg" alt=""></a></li>
            </ul>
            <ul class="indicator"></ul>
        </div>
    </div>
    
    
    
    <div class="event">
        <div class="article">
            <img src="/images/main_v.jpg" alt="">
            <p>놓치고 싶지 않은 데일리 신상 비디오</p>
        </div>
        <div class="article">
            <img src="/images/main_8sale01.jpg" alt="">
            <p>매일매일 신상 8% SALE</p>
        </div>
    </div>
    
    </div>
</body>
</html>