!function(t){var a=function(a,t,n){var e=function template(s){var e=[],i={},n,c=s||{};return function(t){e.push('<div class="c-playback-rate-menu-section"><div class="vjs-menu-title"><h3 class="menu-section-title headline-1-text">'+a.escape(null==(n=t("Playback Rate"))?"":n)+'</h3></div><div class="c-menu-divider"></div><div class="c-playback-rate-button-container"><button data-js="c-playback-rate-minus-button" class="c-playback-rate-button"><em class="cif-minus"></em></button><span data-js="c-playback-rate-text" class="c-playback-rate-text"></span><button data-js="c-playback-rate-plus-button" class="c-playback-rate-button"><em class="cif-plus"></em></button></div></div>')}.call(this,"_t"in c?c._t:"undefined"!=typeof t?t:void 0),e.join("")};return function(a){return a&&"_t"in a&&(t=a._t.merge(t)),e(a)}};"function"==typeof define&&define.amd?define(["js/vendor/jade","i18n!bundles/videojs/layout/nls/playbackRateMenuSection"],function(t,e){var n;return a(t,e,n)}):t.jade.templates["bundles.videojs.layout.playbackRateMenuSection"]=a(t.jade.helpers)}(window);