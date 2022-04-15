import PageTemperature from '@/pages/PageTemperature.vue'
import PageEnergy from '@/pages/PageEnergy.vue'
import PageWeight from '@/pages/PageWeight.vue'
import PageArea from '@/pages/PageArea.vue'
import PageLength from '@/pages/PageLength.vue'

import Home from '@/components/Home.vue'

export const routes = {
    '/home': {
        component: Home
    },
    '/temperature': {
        component: PageTemperature
    },
    '/energy': {
        component: PageEnergy
    },
    '/weight': {
        component: PageWeight
    },
    '/area': {
        component: PageArea
    },
    '/length': {
        component: PageLength
    }
}