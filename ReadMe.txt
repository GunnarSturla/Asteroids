Leikurinn spilast úr Asteroids.java, en annars gerir það ekkert.

Asteroids.java býr til nýjan Game hlut og kallar á play()

Game heldur utan um leikinn sjálfan. Hann býr til alla hlutina á skjánum, kallar á þá, teiknar osfrv.

SpaceObject.java er yfirklasi af geimhlutum. Hann heldur utan um allar þær breytur sem asteroid, Bullet og Ship eiga sameiginlegt, ss. staðsetningu stefnu og snúning. SO inniheldur líka intersects() sem tékkar á árekstrum og move() sem hreyfir hlutinn, allt eftir gildum á hraða, stefnu osfrv. Sérhver undirklasi hefur sitt eigið draw() sem tekinar hlutinn á skjáinn

asteroid.java er sérhvert smástyrni á skjánum. Þau eru í þremur stærðum, og hver stærð hefur 3 mismunandi laganir. asteroid.destroy() eyðir smástyrninu og býr til tvö ný ef það er ekki minnsta stærðin. Í leiknum eru asteriodin geymd í SimpleVector, sem er smá breytt til að bæta við replace, sem skrifar nýtt styrni yfir smástyrnið í því hólfi

Ship.java er skipið sjálft, það getur skotið, en það býr til nýtt Bullet.
Í leiknum eru Bullet-tin eru geymd í 25 staka fylki