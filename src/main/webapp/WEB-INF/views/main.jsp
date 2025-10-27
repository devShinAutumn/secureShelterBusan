<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>SSB ::: Secure Shelter Busan</title>
    <link rel="icon" type="image/png" sizes="16x16" href="/resources/images/favicon.ico">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <script src="https://cdn.amcharts.com/lib/5/index.js"></script>
    <script src="https://cdn.amcharts.com/lib/5/map.js"></script>
    <script src="https://cdn.amcharts.com/lib/5/xy.js"></script>
    <script src="https://cdn.amcharts.com/lib/5/themes/Animated.js"></script>
    <script src="//cdn.amcharts.com/lib/5/percent.js"></script>
    <script src="//cdn.amcharts.com/lib/5/geodata/region/usa/flLow.js"></script>
    <script src="//cdn.amcharts.com/lib/5/themes/Animated.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-ui.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css?v=${System.currentTimeMillis()}" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css?v=${System.currentTimeMillis()}" type="text/css">
    <script src="${pageContext.request.contextPath}/resources/js/mainController.js?v=${System.currentTimeMillis()}"></script>
    <script>getMainDashBoard();</script>
</head>
<body>
<header>
    <a class="logo" href="https://shelter-busan.site/"><h1><img src="/resources/images/logo.png" alt=""></h1></a>
    <div class="location-info">
        <span class="icon"></span>
        <h4 class="text">55, APEC-ro, Haeundae-gu, Busan, Republic of Korea</h4>
    </div>
    <section class="news-ticker">
        <h6 class="info-title">News</h6>
        <div class="news-ticker-wrap">
            <ul class="news-lists">
                <li><h6 class="headline"><strong>[부산시]</strong> 8월19일 02시20분 부산지역 호우주의보 발효.  저지대, 침수 우려지역 등 위험지역에서는 안전에 유의하시기 바랍니다.</h6></li>
                <li><h6 class="headline"><strong>[부산시]</strong> 부산지역 폭염주의보 발효 중. 낮 시간 야외활동(논,밭,공사장) 자제, 충분한 수분 섭취와 휴식으로 건강관리에 유의하시기 바랍니다.</h6></li>
                <li><h6 class="headline"><strong>[동래구청]</strong> 현재 집중호우로 온천천 수위가 높아져 하천 산책로 범람으로 위험하오니, 출입을 자제하여 주시기 바랍니다.</h6></li>
            </ul>
        </div>
        <span class="close-btn"></span>
    </section>
</header>
<div class="main-container">
    <section class="section_01">
        <div class="contents-wrap">
            <div class="content-l">
                <div class="content">
                    <h3 class="cont-title">Overall Risk</h3>
                    <div class="info-box" id="overallRisk"></div>
                </div>
            </div>
            <div class="content-c">
                <div class="content wind">
                    <h3 class="cont-title">Earthquake Prediction</h3>
                    <div class="info-box">
                        <span class="info-value" id="earthquakeRate"></span>
                        <div class="c-container">
                            <div class="percentage" id="earthquakeRateBar"></div>
                        </div>
                    </div>
                </div>
                <div class="content earthquake">
                    <h3 class="cont-title">Tsunami Prediction</h3>
                    <div class="info-box">
                        <span class="info-value" id="shoreRate"></span>
                        <div class="c-container">
                            <div class="percentage" id="shoreRateBar"></div>
                        </div>
                    </div>
                </div>
                <div class="content water">
                    <h3 class="cont-title">Landslide prediction</h3>
                    <div class="info-box">
                        <span class="info-value" id="mountainRate"></span>
                        <div class="c-container">
                            <div class="percentage" id="mountainRateBar"></div>
                        </div>
                    </div>

                </div>
                <div class="content marine">
                    <h3 class="cont-title">Typhoon Prediction</h3>
                    <div class="info-box">
                        <span class="info-value" id="sinkhallRate"></span>
                        <div class="c-container">
                            <div class="percentage" id="sinkhallRateBar"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="content-r">
                <div class="content">
                    <h3 class="cont-title">Satellite Image</h3>
                    <div class="info-box satellite-image">
                        <img src="https://www.kma.go.kr/repositary/image/sat/gk2a/KO/gk2a_ami_le1b_vi006_ko005lc_202308190608.thn.png" />
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section class="section_02">
        <div class="contents-wrap">
            <div class="content prediction">
                <div class="graph-area">
                    <div class="prediction-info-wrap">
                        <div class="prediction-info">
                            <h4 class="graph-name">Wind Sensor</h4>
                            <div class="graph" id="tidalObserv1"></div>
                        </div>
                        <div class="prediction-info">
                            <h4 class="graph-name">Rip current</h4>
                            <div class="graph" id="ripCrntGraph"></div>
                        </div>
                        <div class="prediction-info">
                            <h4 class="graph-name">Barometric Pressure/ Temperature</h4>
                            <div class="graph" id="tidalObserv2"></div>
                        </div>
                        <div class="prediction-info">
                            <h4 class="graph-name">Condolence</h4>
                            <div class="graph" id="tidalObserv3"></div>
                        </div>
                        <div class="prediction-info">
                            <h4 class="graph-name">Precipitation</h4>
                            <div class="graph" id="tidalObserv4"></div>
                        </div>
                        <div class="prediction-info">
                            <h4 class="graph-name">Cloudiness</h4>
                            <div class="graph" id="rhymeRhymeansData"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="content shelter">
                <h3 class="cont-title">Shelter</h3>
                <div class="map-area" id="mapGraph"></div>
            </div>
        </div>
    </section>
</div>
<script>
    $(function(){
        $(document).on('click','.close-btn', function(){
            $(this).parent('.news-ticker').hide();
        })
    });
</script>
</body>
</html>
