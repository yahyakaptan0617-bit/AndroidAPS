# AAPS

## Bu fork hakkında (Türkçe)

Bu depo, AndroidAPS (AAPS) projesinin bir fork'udur. AAPS'in desteklediği pompa ve sensör sürücüleri bu fork'ta da bulunur.

- **Pompalar** (`pump/` klasörü): Combo, Dana, DanaR, DanaRS, Diaconn, EOPatch, Equil, Insight, Medtronic, Medtrum, Omnipod ve sanal pompa.
- **Sensörler** (`plugins/source/` klasörü): Dexcom, Glimp, Glunovo, Intelligo, MM640g, Nightscout istemcisi, Poctech, Syai, Tomato, xDrip ve diğerleri.

### Build almak için

1. Bilgisayarına Android Studio ve uygun JDK'yi kur (güncel sürüm için JDK 21).
2. Fork'u klonla:

```
git clone --recurse-submodules https://github.com/yahyakaptan0617-bit/AndroidAPS.git && cd AndroidAPS
```

3. Android Studio'da klasörü aç ve `full` build türünü seç (`app` modülü, `full` flavor).
4. Uygulamayı imzalamak için kendi keystore dosyanı kullan.

Daha ayrıntılı bilgi için resmî wiki'ye bak: https://wiki.aaps.app

### Release almak için

- Sürüm numarası `buildSrc/src/main/kotlin/Versions.kt` dosyasındaki `appVersion` alanında tutulur.
- Release oluşturmadan önce değişikliklerini gerçek cihazlarla test et.
- Release notlarında bu yazılımın tedavi için onaylı olmadığını ve kullanım sorumluluğunun kullanıcıya ait olduğunu açıkça belirt.

---

* Check the wiki: https://wiki.aaps.app
*  Everyone who’s been looping with AAPS needs to fill out the form after 3 days of looping  https://docs.google.com/forms/d/14KcMjlINPMJHVt28MDRupa4sz4DDIooI4SrW0P3HSN8/viewform?c=0&w=1

[![Support Server](https://img.shields.io/discord/629952586895851530.svg?label=Discord&logo=Discord&colorB=7289da&style=for-the-badge)](https://discord.gg/4fQUWHZ4Mw)

[![CircleCI](https://circleci.com/gh/nightscout/AndroidAPS/tree/master.svg?style=svg)](https://circleci.com/gh/nightscout/AndroidAPS/tree/master)
[![Crowdin](https://d322cqt584bo4o.cloudfront.net/androidaps/localized.svg)](https://translations.aaps.app/project/androidaps)
[![Documentation Status](https://readthedocs.org/projects/androidaps/badge/?version=latest)](https://wiki.aaps.app/en/latest/?badge=latest)
[![codecov](https://codecov.io/gh/nightscout/AndroidAPS/branch/master/graph/badge.svg?token=EmklfIV6bH)](https://codecov.io/gh/nightscout/AndroidAPS)

DEV: 
[![CircleCI](https://circleci.com/gh/nightscout/AndroidAPS/tree/dev.svg?style=svg)](https://circleci.com/gh/nightscout/AndroidAPS/tree/dev)
[![codecov](https://codecov.io/gh/nightscout/AndroidAPS/branch/dev/graph/badge.svg?token=EmklfIV6bH)](https://codecov.io/gh/nightscout/AndroidAPS/tree/dev)

<img src="https://cdn.iconscout.com/icon/free/png-256/bitcoin-384-920569.png" srcset="https://cdn.iconscout.com/icon/free/png-512/bitcoin-384-920569.png 2x" alt="Bitcoin Icon" width="100">

3KawK8aQe48478s6fxJ8Ms6VTWkwjgr9f2
