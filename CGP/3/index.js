var lz77 = require('lz77');

res = lz77.compress(
  "Sanskrit: काचं शक्नोम्यत्तुम् । नोपहिनस्ति माम् ॥ Sanskrit (standard transcription): kācaṃ śaknomyattum; nopahinasti mām. Classical Greek: ὕαλον ϕαγεῖν δύναμαι· τοῦτο οὔ με βλάπτει. Greek (monotonic): Μπορώ να φάω σπασμένα γυαλιά χωρίς να πάθω τίποτα. Greek (polytonic): Μπορῶ νὰ φάω σπασμένα γυαλιὰ χωρὶς νὰ πάθω τίποτα.  Etruscan: (NEEDED) Latin: Vitrum edere possum; mihi non nocet. Old French: Je puis mangier del voirre. Ne me nuit. French: Je peux manger du verre, ça ne me fait pas mal. Provençal / Occitan: Pòdi manjar de veire, me nafrariá pas. Québécois: J'peux manger d'la vitre, ça m'fa pas mal. Walloon: Dji pou magnî do vêre, çoula m' freut nén må.  Champenois: (NEEDED)  Lorrain: (NEEDED) Picard: Ch'peux mingi du verre, cha m'foé mie n'ma.  Corsican/Corsu: (NEEDED)  Jèrriais: (NEEDED) Kreyòl Ayisyen (Haitï): Mwen kap manje vè, li pa blese'm."
);

console.log(res);
