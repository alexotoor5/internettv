#!/bin/bash

echo "===== Downloading InternetTV Logos ====="

BASE_URL="https://raw.githubusercontent.com/iptv-org/iptv/master/logos"

OUT="app/src/main/res"

mkdir -p $OUT/drawable-mdpi
mkdir -p $OUT/drawable-hdpi
mkdir -p $OUT/drawable-xhdpi

# ---- IRIB National ----
curl -L "$BASE_URL/irib-tv1.png" -o "$OUT/drawable-mdpi/ic_tv1.png"
curl -L "$BASE_URL/irib-tv2.png" -o "$OUT/drawable-mdpi/ic_tv2.png"
curl -L "$BASE_URL/irib-tv3.png" -o "$OUT/drawable-mdpi/ic_tv3.png"
curl -L "$BASE_URL/irib-tv4.png" -o "$OUT/drawable-mdpi/ic_tv4.png"
curl -L "$BASE_URL/irib-tv5.png" -o "$OUT/drawable-mdpi/ic_tv5.png"
curl -L "$BASE_URL/irib-news.png" -o "$OUT/drawable-mdpi/ic_irinn.png"

# ---- International ----
curl -L "$BASE_URL/manoto.png" -o "$OUT/drawable-mdpi/ic_manoto.png"
curl -L "$BASE_URL/iranintl.png" -o "$OUT/drawable-mdpi/ic_iint.png"
curl -L "$BASE_URL/bbc-persian.png" -o "$OUT/drawable-mdpi/ic_bbc.png"
curl -L "$BASE_URL/voa.png" -o "$OUT/drawable-mdpi/ic_voa.png"

# ---- Radios ----
curl -L "$BASE_URL/radio-farda.png" -o "$OUT/drawable-mdpi/ic_radio_farda.png"
curl -L "$BASE_URL/radio-javan.png" -o "$OUT/drawable-mdpi/ic_radio_javan.png"

echo "===== Scaling to hdpi & xhdpi ====="

for f in $OUT/drawable-mdpi/*.png; do
  name=$(basename $f)
  convert $f -resize 150% "$OUT/drawable-hdpi/$name"
  convert $f -resize 200% "$OUT/drawable-xhdpi/$name"
done

echo "===== Logos Ready ====="
